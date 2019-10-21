package br.com.mind5.business.materialStock.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
import br.com.mind5.business.masterData.model.checker.MatmovTypeCheckExist;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatockCheckMatmovType implements ModelChecker<MatockInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatmovTypeInfo> checker;
	
	
	public MatockCheckMatmovType(ModelCheckerOption option) {
		checker = new MatmovTypeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatockInfo> recordInfos) {
		for (MatockInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatockInfo recordInfo) {
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
