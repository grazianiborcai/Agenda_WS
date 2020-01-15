package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdOrderemSuccess extends ActionStdSuccessTemplate<OrderemInfo> {
	
	public StdOrderemSuccess(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
}
