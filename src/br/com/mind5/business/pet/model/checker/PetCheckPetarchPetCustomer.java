package br.com.mind5.business.pet.model.checker;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.model.checker.PetarchCheckExistPetCustomer;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;

public final class PetCheckPetarchPetCustomer extends ModelCheckerTemplateForward<PetInfo, PetarchInfo> {
	
	public PetCheckPetarchPetCustomer(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<PetarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new PetarchCheckExistPetCustomer(option);
	}
	
	
	
	@Override protected PetarchInfo toForwardClass(PetInfo baseRecord) {
		return PetarchInfo.copyFrom(baseRecord);
	}
}
