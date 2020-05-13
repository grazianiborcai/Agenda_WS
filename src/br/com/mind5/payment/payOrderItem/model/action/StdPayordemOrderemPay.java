package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemOrderemPay extends ActionStdTemplateV2<PayordemInfo> {

	public StdPayordemOrderemPay(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayordemInfo> buildVisitorHook(DeciTreeOption<PayordemInfo> option) {
		return new VisiPayordemOrderemPay(option);
	}
}
