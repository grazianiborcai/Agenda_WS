package br.com.gda.business.materialEmployee.model.chekcer;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.EmpCheckExistKey;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatEmpCheckEmp implements ModelChecker<MatEmpInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<EmpInfo> checker;
	
	
	public MatEmpCheckEmp(ModelCheckerOption option) {
		checker = new EmpCheckExistKey(option);
	}
	
	
	
	@Override public boolean check(List<MatEmpInfo> recordInfos) {
		for (MatEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(MatEmpInfo recordInfo) {
		return checker.check(recordInfo.toEmpInfo());
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailureExplanation() {
		return checker.getFailureExplanation();
	}

	
	
	@Override public int getFailureCode() {
		return checker.getFailureCode();
	}
}
