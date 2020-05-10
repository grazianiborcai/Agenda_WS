package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipDaoSelect extends ActionStdTemplateV2<WokaymoipInfo> {

	public StdWokaymoipDaoSelect(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<WokaymoipInfo> buildVisitorHook(DeciTreeOption<WokaymoipInfo> option) {
		return new VisiWokaymoipDaoSelect(option);
	}
}