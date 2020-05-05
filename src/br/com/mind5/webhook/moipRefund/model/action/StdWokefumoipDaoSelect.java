package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipDaoSelect extends ActionStdTemplateV2<WokefumoipInfo> {

	public StdWokefumoipDaoSelect(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<WokefumoipInfo> buildVisitorHook(DeciTreeOption<WokefumoipInfo> option) {
		return new VisiWokefumoipDaoSelect(option);
	}
}
