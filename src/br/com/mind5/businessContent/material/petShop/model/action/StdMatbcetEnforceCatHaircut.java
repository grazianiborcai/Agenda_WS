package br.com.mind5.businessContent.material.petShop.model.action;

import br.com.mind5.businessContent.material.petShop.info.MatbcetInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdMatbcetEnforceCatHaircut extends ActionStdTemplateV2<MatbcetInfo> {

	public StdMatbcetEnforceCatHaircut(DeciTreeOption<MatbcetInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<MatbcetInfo> buildVisitorHook(DeciTreeOption<MatbcetInfo> option) {
		return new VisiMatbcetEnforceCatHaircut(option);
	}
}
