package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class CompCheckEntiteg extends ModelCheckerTemplateForwardV2<CompInfo, EntitegInfo> {
	
	public CompCheckEntiteg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<EntitegInfo> getCheckerHook(ModelCheckerOption option) {
		return new EntitegCheckExist(option);
	}
	
	
	
	@Override protected EntitegInfo toForwardClass(CompInfo baseRecord) {
		return EntitegInfo.copyFrom(baseRecord);
	}
}
