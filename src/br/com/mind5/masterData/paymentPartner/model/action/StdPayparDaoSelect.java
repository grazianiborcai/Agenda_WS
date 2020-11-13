package br.com.mind5.masterData.paymentPartner.model.action;

import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPayparDaoSelect extends ActionStdTemplate<PayparInfo> {

	public StdPayparDaoSelect(DeciTreeOption<PayparInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayparInfo> buildVisitorHook(DeciTreeOption<PayparInfo> option) {
		return new VisiPayparDaoSelect(option);
	}
}
