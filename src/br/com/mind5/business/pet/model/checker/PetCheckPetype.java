package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.masterData.petType.model.checker.PetypeCheckExist;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckPetype extends ModelCheckerTemplateForward<PetInfo, PetypeInfo> {
	
	public PetCheckPetype(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetypeInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetypeCheckExist(option);
	}
	
	
	
	@Override protected PetypeInfo toForwardClass(PetInfo baseRecord) {
		return PetypeInfo.copyFrom(baseRecord);
	}
}
