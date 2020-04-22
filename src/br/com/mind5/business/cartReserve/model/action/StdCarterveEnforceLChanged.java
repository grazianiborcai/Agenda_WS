package br.com.mind5.business.cartReserve.model.action;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCarterveEnforceLChanged extends ActionStdTemplateV2<CarterveInfo> {

	public StdCarterveEnforceLChanged(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CarterveInfo> buildVisitorHook(DeciTreeOption<CarterveInfo> option) {
		return new VisiCarterveEnforceLChanged(option);
	}
}
