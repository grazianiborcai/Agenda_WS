package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemMergeToUpdate extends ActionStdTemplate<PayordemInfo> {

	public StdPayordemMergeToUpdate(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordemInfo> buildVisitorHook(DeciTreeOption<PayordemInfo> option) {
		return new VisiPayordemMergeToUpdate(option);
	}
}
