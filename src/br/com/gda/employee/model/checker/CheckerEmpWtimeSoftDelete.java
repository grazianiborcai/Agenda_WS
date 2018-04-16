package br.com.gda.employee.model.checker;

import javax.ws.rs.core.Response;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.EmpWtimeModelSelect;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerTemplate;

public final class CheckerEmpWtimeSoftDelete extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean EMPLOYEE_WORKING_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;
	private static final boolean EXPECTED_NOT_DELETED = false;
	
	
	public CheckerEmpWtimeSoftDelete() {
		super(EXPECTED_NOT_DELETED);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo) {		
		EmpWTimeInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		EmpWtimeModelSelect readDatabase = new EmpWtimeModelSelect(clonedInfo);
		readDatabase.executeRequest();
		Response response = readDatabase.getResponse();
		
		if (response.getStatus() == Response.Status.OK.getStatusCode()) 
			return EMPLOYEE_WORKING_IS_DELETED;
		
		if (response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) 
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);			
		
		return NOT_FOUND_OR_NOT_DELETED;
	}
	
	
	
	private EmpWTimeInfo makeClone(EmpWTimeInfo recordInfo) {
		try {
			return (EmpWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMPLOYEE_WORKING_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMPLOYEE_WORKING_FLAGGED_AS_DELETED;	
	}
}
