package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.model.checker.PetaultCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckPetault extends ModelCheckerTemplateForward<PetInfo, PetaultInfo> {
	
	public PetCheckPetault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetaultCheckExist(option);
	}
	
	
	
	@Override protected PetaultInfo toForwardClass(PetInfo baseRecord) {
		return PetaultInfo.copyFrom(baseRecord);
	}
}
