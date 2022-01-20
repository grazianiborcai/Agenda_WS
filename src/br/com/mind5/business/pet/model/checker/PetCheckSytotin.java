package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.config.sysStorePartitioning.info.SytotinInfo;
import br.com.mind5.config.sysStorePartitioning.model.checker.SytotinCheckEnabled;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckSytotin extends ModelCheckerTemplateForward<PetInfo, SytotinInfo> {
	
	public PetCheckSytotin(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SytotinInfo> getCheckerHook(ModelCheckerOption option) {
		return new SytotinCheckEnabled(option);
	}
	
	
	
	@Override protected SytotinInfo toForwardClass(PetInfo baseRecord) {
		return SytotinInfo.copyFrom(baseRecord);
	}
}
