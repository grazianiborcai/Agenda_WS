package br.com.mind5.business.employeeWorkTimeConflict.model.checker;

import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.model.checker.EmpCheckExist;
import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class EmpwocoCheckEmp implements ModelChecker<EmpwocoInfo> {	
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpInfo> checker;
	
	
	public EmpwocoCheckEmp(ModelCheckerOption option) {
		checker = new EmpCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpwocoInfo> recordInfos) {
		for (EmpwocoInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpwocoInfo recordInfo) {
		return checker.check(EmpInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
