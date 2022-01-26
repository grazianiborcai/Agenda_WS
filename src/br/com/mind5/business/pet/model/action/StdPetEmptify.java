package br.com.mind5.business.pet.model.action;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPetEmptify extends ActionStdSuccessTemplate<PetInfo> {
	public StdPetEmptify(DeciTreeOption<PetInfo> option) {
		super(PetInfo.class);
	}
}
