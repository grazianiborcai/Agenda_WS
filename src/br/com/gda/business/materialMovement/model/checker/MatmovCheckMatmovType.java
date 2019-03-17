package br.com.gda.business.materialMovement.model.checker;

import java.util.List;

import br.com.gda.business.masterData.info.MatmovTypeInfo;
import br.com.gda.business.masterData.model.checker.MatmovTypeCheckExist;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatmovCheckMatmovType implements ModelChecker<MatmovInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatmovTypeInfo> checker;
	
	
	public MatmovCheckMatmovType(ModelCheckerOption option) {
		checker = new MatmovTypeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatmovInfo> recordInfos) {
		for (MatmovInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatmovInfo recordInfo) {
		return checker.check(MatmovTypeInfo.copyFrom(recordInfo));
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
