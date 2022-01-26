package br.com.mind5.business.petDefault.model.action;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetaultMergeToSelect extends ActionStdTemplate<PetaultInfo> {

	public StdPetaultMergeToSelect(DeciTreeOption<PetaultInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetaultInfo> buildVisitorHook(DeciTreeOption<PetaultInfo> option) {
		return new VisiPetaultMergeToSelect(option);
	}
}
