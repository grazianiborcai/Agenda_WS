package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipSuccess extends ActionStdSuccessTemplate<WokaymoipInfo> {
	
	public StdWokaymoipSuccess(DeciTreeOption<WokaymoipInfo> option) {
		super(WokaymoipInfo.class);
	}
}
