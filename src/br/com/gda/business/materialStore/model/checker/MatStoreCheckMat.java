package br.com.gda.business.materialStore.model.checker;

import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.MatCheckExistKey;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatStoreCheckMat implements ModelChecker<MatStoreInfo> {
	private final boolean RESULT_FAILED = false;
	private final boolean RESULT_SUCCESS = true;
	
	private ModelChecker<MatInfo> checker;
	
	
	public MatStoreCheckMat(ModelCheckerOption option) {
		checker = new MatCheckExistKey(option);
	}
	
	
	
	@Override public boolean check(List<MatStoreInfo> recordInfos) {
		for (MatStoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == RESULT_FAILED)
				return RESULT_FAILED;
		}
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public boolean check(MatStoreInfo recordInfo) {
		return checker.check(recordInfo.toMatInfo());
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
