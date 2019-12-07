package br.com.mind5.file.fileImage.model.checker;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class FimgCheckMat implements ModelChecker<FimgInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatInfo> checker;
	
	
	public FimgCheckMat(ModelCheckerOption option) {
		checker = new MatCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<FimgInfo> recordInfos) {
		for (FimgInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(FimgInfo recordInfo) {
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
