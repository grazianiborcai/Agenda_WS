package br.com.mind5.business.order.model.action;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderMargeOrdugeCancel extends ActionStdTemplateV2<OrderInfo> {

	public StdOrderMargeOrdugeCancel(DeciTreeOption<OrderInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrderInfo> buildVisitorHook(DeciTreeOption<OrderInfo> option) {
		return new VisiOrderMergeOrdugeCancel(option);
	}
}
