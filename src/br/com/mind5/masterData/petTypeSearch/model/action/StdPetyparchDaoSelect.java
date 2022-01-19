package br.com.mind5.masterData.petTypeSearch.model.action;

import br.com.mind5.masterData.petTypeSearch.info.PetyparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetyparchDaoSelect extends ActionStdTemplate<PetyparchInfo> {

	public StdPetyparchDaoSelect(DeciTreeOption<PetyparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetyparchInfo> buildVisitorHook(DeciTreeOption<PetyparchInfo> option) {
		return new VisiPetyparchDaoSelect(option);
	}
}
