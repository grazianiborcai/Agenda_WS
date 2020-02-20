package br.com.mind5.payment.payOrder.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class StdPayordSuccess extends ActionStdSuccessTemplate<PayordInfo> {

	public StdPayordSuccess(DeciTreeOption<PayordInfo> option) {
		super(option);
	}
}
