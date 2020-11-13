package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StdStoparEnforceDel extends ActionStdTemplate<StoparInfo> {

	public StdStoparEnforceDel(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoparInfo> buildVisitorHook(DeciTreeOption<StoparInfo> option) {
		return new VisiStoparEnforceDel(option);
	}
}
