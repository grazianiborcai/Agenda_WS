package br.com.mind5.payment.storePartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StdStoparchDaoSelect extends ActionStdTemplateV2<StoparchInfo> {

	public StdStoparchDaoSelect(DeciTreeOption<StoparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoparchInfo> buildVisitorHook(DeciTreeOption<StoparchInfo> option) {
		return new VisiStoparchDaoSelect(option);
	}
}
