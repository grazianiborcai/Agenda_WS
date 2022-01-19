package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.masterData.petWeight.model.checker.PeteightCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckPeteight extends ModelCheckerTemplateForward<PetInfo, PeteightInfo> {
	
	public PetCheckPeteight(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PeteightInfo> getCheckerHook(ModelCheckerOption option) {
		return new PeteightCheckExist(option);
	}
	
	
	
	@Override protected PeteightInfo toForwardClass(PetInfo baseRecord) {
		return PeteightInfo.copyFrom(baseRecord);
	}
}
