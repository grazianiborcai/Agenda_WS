package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StdStoparStoparnapInsert extends ActionStdTemplateV2<StoparInfo> {

	public StdStoparStoparnapInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StoparInfo> buildVisitorHook(DeciTreeOption<StoparInfo> option) {
		return new VisiStoparStoparnapInsert(option);
	}
}