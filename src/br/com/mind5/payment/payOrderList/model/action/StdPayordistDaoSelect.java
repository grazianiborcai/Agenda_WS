package br.com.mind5.payment.payOrderList.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class StdPayordistDaoSelect extends ActionStdTemplate<PayordistInfo> {

	public StdPayordistDaoSelect(DeciTreeOption<PayordistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordistInfo> buildVisitorHook(DeciTreeOption<PayordistInfo> option) {
		return new VisiPayordistDaoSelect(option);
	}
}
