package br.com.mind5.payment.storePartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StdStoparDaoInsert extends ActionStdTemplate<StoparInfo> {

	public StdStoparDaoInsert(DeciTreeOption<StoparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<StoparInfo> buildVisitorHook(DeciTreeOption<StoparInfo> option) {
		return new VisiStoparDaoInsert(option);
	}
}
