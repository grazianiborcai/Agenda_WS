package br.com.gda.employee.model.checker;

import javax.ws.rs.core.Response;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.employee.model.EmpWtimeModelSelect;
import br.com.gda.model.checker.ModelCheckerTemplate;

public class CheckerEmpWtimeExistOnDb extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean EMPLOYEE_WORKING_TIME_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CheckerEmpWtimeExistOnDb(boolean expectedResult) {
		super(expectedResult);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo) {		
		EmpWtimeModelSelect readDatabase = new EmpWtimeModelSelect(recordInfo);
		readDatabase.executeRequest();
		Response response = readDatabase.getResponse();
		
		if (response.getStatus() == Response.Status.OK.getStatusCode()) 
			return EMPLOYEE_WORKING_TIME_EXIST;
		
		if (response.getStatus() == Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()) 
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);			
		
		return NO_ENTRY_FOUND_ON_DB;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB)
			return SystemMessage.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB;
		
		return SystemMessage.EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EMPLOYEE_WORKING_TIME_EXIST)
			return SystemCode.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB;	
			
		return SystemCode.EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB;
	}
}
