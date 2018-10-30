package br.com.gda.business.materialEmployee.model.chekcer;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.EmpCheckExist;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatEmpCheckEmp implements ModelChecker<MatEmpInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<EmpInfo> checker;
	
	
	public MatEmpCheckEmp(ModelCheckerOption option) {
		checker = new EmpCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatEmpInfo> recordInfos) {
		for (MatEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatEmpInfo recordInfo) {
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
