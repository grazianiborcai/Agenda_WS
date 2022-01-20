package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckExistPetUser;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckPetarchPetUser extends ModelCheckerTemplateForward<PetInfo, PetarchInfo> {
	
	public PetCheckPetarchPetUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetarchCheckExistPetUser(option);
	}
	
	
	
	@Override protected PetarchInfo toForwardClass(PetInfo baseRecord) {
		return PetarchInfo.copyFrom(baseRecord);
	}
}
