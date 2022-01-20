package br.com.mind5.business.pet.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.model.decisionTree.RootPetUpdateAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetModelUpdateAuth extends ModelTemplate<PetInfo> {

	public PetModelUpdateAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PetInfo.class);
	}
	
	
	
	@Override protected DeciTree<PetInfo> getDecisionTreeHook(DeciTreeOption<PetInfo> option) {
		return new RootPetUpdateAuth(option);
	}
}
