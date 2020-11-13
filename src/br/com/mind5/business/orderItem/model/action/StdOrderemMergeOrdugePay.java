package br.com.mind5.business.orderItem.model.action;

import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderemMergeOrdugePay extends ActionStdTemplate<OrderemInfo> {

	public StdOrderemMergeOrdugePay(DeciTreeOption<OrderemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderemInfo> buildVisitorHook(DeciTreeOption<OrderemInfo> option) {
		return new VisiOrderemMergeOrdugePay(option);
	}
}
