package br.com.mind5.payment.statusPayOrderItem.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class StdPaytusemPayordemUpdate extends ActionStdTemplate<PaytusemInfo> {

	public StdPaytusemPayordemUpdate(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PaytusemInfo> buildVisitorHook(DeciTreeOption<PaytusemInfo> option) {
		return new VisiPaytusemPayordemUpdate(option);
	}
}
