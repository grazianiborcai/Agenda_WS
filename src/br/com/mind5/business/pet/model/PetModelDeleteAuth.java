package br.com.mind5.business.pet.model;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.RootPetDeleteAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetModelDeleteAuth extends ModelTemplate<PetInfo> {

	public PetModelDeleteAuth(PetInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<PetInfo> getDecisionTreeHook(DeciTreeOption<PetInfo> option) {
		return new RootPetDeleteAuth(option);
	}
}
