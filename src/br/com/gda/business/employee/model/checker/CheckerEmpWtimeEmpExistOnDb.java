package br.com.gda.business.employee.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CheckerEmpWtimeEmpExistOnDb implements ModelChecker<EmpWTimeInfo> {	
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	
	private ModelChecker<EmpInfo> checkerEmp;
	
	
	public CheckerEmpWtimeEmpExistOnDb(ModelCheckerOption option) {
		checkerEmp = new CheckerEmpExistOnDb(option);
	}


	
	@Override public boolean check(List<EmpWTimeInfo> recordInfos) {
		for (EmpWTimeInfo eachRecord : recordInfos) {
			boolean resultCheck = check(eachRecord);
			
			if (resultCheck == RESULT_FAILED)
				return RESULT_FAILED;
		}		
		
		return RESULT_SUCCESS;
	}


	
	@Override public boolean check(EmpWTimeInfo recordInfo) {
		EmpInfo employeeInfo = new EmpInfo();
		employeeInfo.codOwner = recordInfo.codOwner;
		employeeInfo.codEmployee = recordInfo.codEmployee;
		
		return checkerEmp.check(employeeInfo);
	}


	
	@Override public boolean getResult() {
		return checkerEmp.getResult();
	}


	
	@Override public String getFailureExplanation() {
		return checkerEmp.getFailureExplanation();
	}


	
	@Override public int getFailureCode() {
		return checkerEmp.getFailureCode();
	}
}
