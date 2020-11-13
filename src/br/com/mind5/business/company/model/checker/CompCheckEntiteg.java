package br.com.mind5.business.company.model.checker;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;
import br.com.mind5.masterData.entityCategory.model.checker.EntitegCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class CompCheckEntiteg extends ModelCheckerTemplateForward<CompInfo, EntitegInfo> {
	
	public CompCheckEntiteg(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<EntitegInfo> getCheckerHook(ModelCheckerOption option) {
		return new EntitegCheckExist(option);
	}
	
	
	
	@Override protected EntitegInfo toForwardClass(CompInfo baseRecord) {
		return EntitegInfo.copyFrom(baseRecord);
	}
}
