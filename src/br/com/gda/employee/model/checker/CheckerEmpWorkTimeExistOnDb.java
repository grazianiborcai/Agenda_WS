package br.com.gda.employee.model.checker;

import javax.ws.rs.core.Response;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.employee.model.EmpWorkTimeModelSelect;
import br.com.gda.model.checker.ModelCheckerAbstract;

class CheckerEmpWorkTimeExistOnDb extends ModelCheckerAbstract<EmpWorkTimeInfo> {
	private final boolean EMPLOYEE_WORKING_TIME_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	
	public CheckerEmpWorkTimeExistOnDb(boolean expectedResult) {
		super(expectedResult);
	}
	
	
	
	@Override protected boolean checkHook(EmpWorkTimeInfo recordInfo) {		
		EmpWorkTimeModelSelect readDatabase = new EmpWorkTimeModelSelect(recordInfo);
		readDatabase.executeRequest();
		Response response = readDatabase.getResponse();
		
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			return EMPLOYEE_WORKING_TIME_EXIST;
		}		
		
		return NO_ENTRY_FOUND_ON_DB;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return SystemMessage.OPERATION_CANT_BE_PROCESSED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EMPLOYEE_WORKING_TIME_EXIST) {
			return SystemCode.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB;
		} else {
			return SystemCode.EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB;
		}
	}
}
