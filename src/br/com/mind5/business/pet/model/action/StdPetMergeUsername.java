package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetMergeUsername extends ActionStdTemplate<PetInfo> {

	public StdPetMergeUsername(DeciTreeOption<PetInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetInfo> buildVisitorHook(DeciTreeOption<PetInfo> option) {
		return new VisiPetMergeUsername(option);
	}
}
