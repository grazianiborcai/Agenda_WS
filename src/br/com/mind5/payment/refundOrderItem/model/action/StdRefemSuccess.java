package br.com.mind5.payment.refundOrderItem.model.action;

import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;

public final class StdRefemSuccess extends ActionStdSuccessTemplate<RefemInfo> {

	public StdRefemSuccess(DeciTreeOption<RefemInfo> option) {
		super(option);
	}
}
