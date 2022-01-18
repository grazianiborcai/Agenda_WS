package br.com.mind5.masterData.petType.model.action;

import br.com.mind5.masterData.petType.info.PetypeInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetypeDaoSelect extends ActionStdTemplate<PetypeInfo> {

	public StdPetypeDaoSelect(DeciTreeOption<PetypeInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetypeInfo> buildVisitorHook(DeciTreeOption<PetypeInfo> option) {
		return new VisiPetypeDaoSelect(option);
	}
}
