package br.com.mind5.business.material.model.checker;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.checker.MatoupCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatCheckMatoup implements ModelCheckerV1<MatInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<MatoupInfo> checker;
	
	
	public MatCheckMatoup(ModelCheckerOption option) {
		checker = new MatoupCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatInfo> recordInfos) {
		for (MatInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatInfo recordInfo) {
		return checker.check(MatoupInfo.copyFrom(recordInfo));
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