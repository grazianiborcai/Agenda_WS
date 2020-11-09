package br.com.mind5.payment.storePartnerSnapshot.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StdStoparnapDaoInsert extends ActionStdTemplateV2<StoparnapInfo> {

	public StdStoparnapDaoInsert(DeciTreeOption<StoparnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoparnapInfo> buildVisitorHook(DeciTreeOption<StoparnapInfo> option) {
		return new VisiStoparnapDaoSelect(option);
	}
}
