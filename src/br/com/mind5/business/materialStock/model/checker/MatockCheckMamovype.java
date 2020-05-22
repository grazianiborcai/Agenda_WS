package br.com.mind5.business.materialStock.model.checker;

import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;
import br.com.mind5.masterData.movimentType.model.checker.MamovypeCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatockCheckMamovype implements ModelCheckerV1<MatockInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<MamovypeInfo> checker;
	
	
	public MatockCheckMamovype(ModelCheckerOption option) {
		checker = new MamovypeCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatockInfo> recordInfos) {
		for (MatockInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatockInfo recordInfo) {
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
