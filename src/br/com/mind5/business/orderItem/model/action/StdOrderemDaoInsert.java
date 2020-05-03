package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderemDaoInsert extends ActionStdTemplateV2<OrderemInfo> {

	public StdOrderemDaoInsert(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrderemInfo> buildVisitorHook(DeciTreeOption<OrderemInfo> option) {
		return new VisiOrderemDaoInsert(option);
	}
}
