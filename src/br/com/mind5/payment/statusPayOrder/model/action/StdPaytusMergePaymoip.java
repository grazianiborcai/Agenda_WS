package br.com.mind5.payment.statusPayOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusMergePaymoip extends ActionStdTemplate<PaytusInfo> {

	public StdPaytusMergePaymoip(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PaytusInfo> buildVisitorHook(DeciTreeOption<PaytusInfo> option) {
		return new VisiPaytusMergePaymoip(option);
	}
}
