package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcetEnforceCatHydration extends ActionStdTemplate<MatbcetInfo> {

	public StdMatbcetEnforceCatHydration(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<MatbcetInfo> buildVisitorHook(DeciTreeOption<MatbcetInfo> option) {
		return new VisiMatbcetEnforceCatHydration(option);
	}
}
