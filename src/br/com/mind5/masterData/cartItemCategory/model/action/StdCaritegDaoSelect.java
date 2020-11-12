package br.com.mind5.masterData.cartItemCategory.model.action;

import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaritegDaoSelect extends ActionStdTemplateV2<CaritegInfo> {

	public StdCaritegDaoSelect(DeciTreeOption<CaritegInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CaritegInfo> buildVisitorHook(DeciTreeOption<CaritegInfo> option) {
		return new VisiCaritegDaoSelect(option);
	}
}
