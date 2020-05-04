package br.com.mind5.payment.refundOrder.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrder.info.RefuInfo;

public final class StdRefuMergePayormarch extends ActionStdTemplateV2<RefuInfo> {

	public StdRefuMergePayormarch(DeciTreeOption<RefuInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefuInfo> buildVisitorHook(DeciTreeOption<RefuInfo> option) {
		return new VisiRefuMergePayormarch(option);
	}
}
