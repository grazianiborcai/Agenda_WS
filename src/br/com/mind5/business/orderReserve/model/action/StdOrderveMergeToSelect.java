package br.com.mind5.business.orderReserve.model.action;

import br.com.mind5.business.orderReserve.info.OrderveInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderveMergeToSelect extends ActionStdTemplateV2<OrderveInfo> {

	public StdOrderveMergeToSelect(DeciTreeOption<OrderveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrderveInfo> buildVisitorHook(DeciTreeOption<OrderveInfo> option) {
		return new VisiOrderveMergeToSelect(option);
	}
}
