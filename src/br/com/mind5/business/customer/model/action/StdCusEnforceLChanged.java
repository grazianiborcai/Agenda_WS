package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusEnforceLChanged extends ActionStdTemplateV2<CusInfo> {

	public StdCusEnforceLChanged(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CusInfo> buildVisitorHook(DeciTreeOption<CusInfo> option) {
		return new VisiCusEnforceLChanged(option);
	}
}
