package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcetEnforceCatHydration extends ActionStdTemplateV2<MatbcetInfo> {

	public StdMatbcetEnforceCatHydration(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatbcetInfo> buildVisitorHook(DeciTreeOption<MatbcetInfo> option) {
		return new VisiMatbcetEnforceCatHydration(option);
	}
}
