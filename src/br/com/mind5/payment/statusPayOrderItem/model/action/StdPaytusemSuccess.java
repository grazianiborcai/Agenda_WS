package br.com.mind5.payment.statusPayOrderItem.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrderItem.info.PaytusemInfo;

public final class StdPaytusemSuccess extends ActionStdSuccessTemplate<PaytusemInfo> {

	public StdPaytusemSuccess(DeciTreeOption<PaytusemInfo> option) {
		super(option);
	}
}
