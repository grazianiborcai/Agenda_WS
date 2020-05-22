package br.com.mind5.business.materialMovement.model.checker;

import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatmovCheckMamovype implements ModelCheckerV1<MatmovInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<MamovypeInfo> checker;
	
	
	public MatmovCheckMamovype(ModelCheckerOption option) {
		checker = new MamovypeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatmovInfo> recordInfos) {
		for (MatmovInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatmovInfo recordInfo) {
		return checker.check(MamovypeInfo.copyFrom(recordInfo));
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
