package br.com.mind5.payment.payOrderItemList.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class StdPayordemistMergeToSelect extends ActionStdTemplate<PayordemistInfo> {

	public StdPayordemistMergeToSelect(DeciTreeOption<PayordemistInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayordemistInfo> buildVisitorHook(DeciTreeOption<PayordemistInfo> option) {
		return new VisiPayordemistMergeToSelect(option);
	}
}
