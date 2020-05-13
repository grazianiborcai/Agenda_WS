package br.com.mind5.payment.payOrderItem.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class StdPayordemSuccess extends ActionStdSuccessTemplate<PayordemInfo> {

	public StdPayordemSuccess(DeciTreeOption<PayordemInfo> option) {
		super(option);
	}
}
