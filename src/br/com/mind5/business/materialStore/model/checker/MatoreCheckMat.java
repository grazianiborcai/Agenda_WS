package br.com.mind5.business.materialStore.model.checker;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatoreCheckMat implements ModelChecker<MatoreInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatInfo> checker;
	
	
	public MatoreCheckMat(ModelCheckerOption option) {
		checker = new MatCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatoreInfo> recordInfos) {
		for (MatoreInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatoreInfo recordInfo) {
		return checker.check(MatInfo.copyFrom(recordInfo));
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
