package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipDaoSelect extends ActionStdTemplate<WokefumoipInfo> {

	public StdWokefumoipDaoSelect(DeciTreeOption<WokefumoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<WokefumoipInfo> buildVisitorHook(DeciTreeOption<WokefumoipInfo> option) {
		return new VisiWokefumoipDaoSelect(option);
	}
}
