package br.com.mind5.business.petList.model;

import javax.servlet.http.HttpServletRequest;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.business.petList.model.decisionTree.RootPetlisSearchAuth;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetlisModelSearchAuth extends ModelTemplate<PetlisInfo> {

	public PetlisModelSearchAuth(String incomingData, HttpServletRequest request) {
		super(incomingData, request, PetlisInfo.class);
	}
	
	
	
	@Override protected DeciTree<PetlisInfo> getDecisionTreeHook(DeciTreeOption<PetlisInfo> option) {
		return new RootPetlisSearchAuth(option);
	}
}
