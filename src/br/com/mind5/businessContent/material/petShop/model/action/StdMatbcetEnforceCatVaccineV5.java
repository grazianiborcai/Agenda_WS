package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcetEnforceCatVaccineV5 extends ActionStdTemplate<MatbcetInfo> {

	public StdMatbcetEnforceCatVaccineV5(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatbcetInfo> buildVisitorHook(DeciTreeOption<MatbcetInfo> option) {
		return new VisiMatbcetEnforceCatVaccineV5(option);
	}
}
