package br.com.mind5.business.pet.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.RootPetInsertAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetModelInsertAuth extends ModelTemplate<PetInfo> {

	public PetModelInsertAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PetInfo.class);
	}
	
	
	
	@Override protected DeciTree<PetInfo> getDecisionTreeHook(DeciTreeOption<PetInfo> option) {
		return new RootPetInsertAuth(option);
	}
}
