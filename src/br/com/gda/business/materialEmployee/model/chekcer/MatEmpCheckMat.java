package br.com.gda.business.materialEmployee.model.chekcer;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.MatCheckExistKey;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatEmpCheckMat implements ModelChecker<MatEmpInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<MatInfo> checker;
	
	
	public MatEmpCheckMat(ModelCheckerOption option) {
		checker = new MatCheckExistKey(option);
	}
	
	
	
	@Override public boolean check(List<MatEmpInfo> recordInfos) {
		for (MatEmpInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(MatEmpInfo recordInfo) {
		return checker.check(MatInfo.copyFrom(recordInfo));
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
