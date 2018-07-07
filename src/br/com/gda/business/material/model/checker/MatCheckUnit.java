package br.com.gda.business.material.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.business.masterData.model.checker.MatUnitCheckExist;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatCheckUnit implements ModelChecker<MatInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<MatUnitInfo> checker;
	
	
	public MatCheckUnit(ModelCheckerOption option) {
		checker = new MatUnitCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatInfo> recordInfos) {
		for (MatInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(MatInfo recordInfo) {
		return checker.check(MatUnitInfo.copyFrom(recordInfo));
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
