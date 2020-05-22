package br.com.mind5.business.company.model.checker;

import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckExist;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class CompCheckEntiteg implements ModelCheckerV1<CompInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelCheckerV1<EntitegInfo> checker;
	
	
	public CompCheckEntiteg(ModelCheckerOption option) {
		checker = new EntitegCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<CompInfo> recordInfos) {
		for (CompInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(CompInfo recordInfo) {
		return checker.check(EntitegInfo.copyFrom(recordInfo));
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
