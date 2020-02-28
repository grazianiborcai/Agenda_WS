package br.com.mind5.payment.statusPayOrder.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.statusPayOrder.info.PaytusInfo;

public final class StdPaytusSuccess extends ActionStdSuccessTemplate<PaytusInfo> {

	public StdPaytusSuccess(DeciTreeOption<PaytusInfo> option) {
		super(option);
	}
}
