package br.com.mind5.payment.statusPayOrderItem.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class StdPaytusemPayordemUpdate extends ActionStdTemplateV2<PaytusemInfo> {

	public StdPaytusemPayordemUpdate(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PaytusemInfo> buildVisitorHook(DeciTreeOption<PaytusemInfo> option) {
		return new VisiPaytusemPayordemUpdate(option);
	}
}
