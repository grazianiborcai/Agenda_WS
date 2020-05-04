package br.com.mind5.payment.statusPayOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusMergePaymoip extends ActionStdTemplateV2<PaytusInfo> {

	public StdPaytusMergePaymoip(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaytusInfo> buildVisitorHook(DeciTreeOption<PaytusInfo> option) {
		return new VisiPaytusMergePaymoip(option);
	}
}
