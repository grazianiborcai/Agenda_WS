package br.com.mind5.payment.customerPartner.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartner.info.CusparInfo;

public final class StdCusparEnforceCompoundId extends ActionStdTemplate<CusparInfo> {

	public StdCusparEnforceCompoundId(DeciTreeOption<CusparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusparInfo> buildVisitorHook(DeciTreeOption<CusparInfo> option) {
		return new VisiCusparEnforceCompoundId(option);
	}
}
