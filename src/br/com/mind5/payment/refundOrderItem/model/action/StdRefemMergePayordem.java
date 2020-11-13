package br.com.mind5.payment.refundOrderItem.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class StdRefemMergePayordem extends ActionStdTemplate<RefemInfo> {

	public StdRefemMergePayordem(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<RefemInfo> buildVisitorHook(DeciTreeOption<RefemInfo> option) {
		return new VisiRefemMergePayordem(option);
	}
}
