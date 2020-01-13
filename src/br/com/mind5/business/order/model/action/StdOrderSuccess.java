package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderSuccess extends ActionStdSuccessTemplate<OrderInfo> {

	public StdOrderSuccess(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
}
