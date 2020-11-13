package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class StdPayordDaoSelect extends ActionStdTemplate<PayordInfo> {

	public StdPayordDaoSelect(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordInfo> buildVisitorHook(DeciTreeOption<PayordInfo> option) {
		return new VisiPayordDaoSelect(option);
	}
}
