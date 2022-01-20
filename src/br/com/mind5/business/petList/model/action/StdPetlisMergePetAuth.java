package br.com.mind5.business.petList.model.action;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetlisMergePetAuth extends ActionStdTemplate<PetlisInfo> {

	public StdPetlisMergePetAuth(DeciTreeOption<PetlisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PetlisInfo> buildVisitorHook(DeciTreeOption<PetlisInfo> option) {
		return new VisiPetlisMergePetAuth(option);
	}
}
