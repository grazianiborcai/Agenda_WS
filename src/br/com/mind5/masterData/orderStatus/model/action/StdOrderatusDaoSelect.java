package br.com.mind5.masterData.orderStatus.model.action;

import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderatusDaoSelect extends ActionStdTemplate<OrderatusInfo> {

	public StdOrderatusDaoSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrderatusInfo> buildVisitorHook(DeciTreeOption<OrderatusInfo> option) {
		return new VisiOrderatusDaoSelect(option);
	}
}
