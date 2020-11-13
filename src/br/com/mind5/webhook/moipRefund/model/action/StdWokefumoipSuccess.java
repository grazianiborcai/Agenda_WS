package br.com.mind5.webhook.moipRefund.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class StdWokefumoipSuccess extends ActionStdSuccessTemplate<WokefumoipInfo> {
	
	public StdWokefumoipSuccess(DeciTreeOption<WokefumoipInfo> option) {
		super(WokefumoipInfo.class);
	}
}
