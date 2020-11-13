package br.com.mind5.payment.storePartnerSnapshot.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StdStoparnapDaoSelect extends ActionStdTemplate<StoparnapInfo> {

	public StdStoparnapDaoSelect(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoparnapInfo> buildVisitorHook(DeciTreeOption<StoparnapInfo> option) {
		return new VisiStoparnapDaoSelect(option);
	}
}
