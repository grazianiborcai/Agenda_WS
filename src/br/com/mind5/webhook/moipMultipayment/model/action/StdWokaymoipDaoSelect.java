package br.com.mind5.webhook.moipMultipayment.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class StdWokaymoipDaoSelect extends ActionStdTemplate<WokaymoipInfo> {

	public StdWokaymoipDaoSelect(DeciTreeOption<WokaymoipInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<WokaymoipInfo> buildVisitorHook(DeciTreeOption<WokaymoipInfo> option) {
		return new VisiWokaymoipDaoSelect(option);
	}
}
