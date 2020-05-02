package br.com.mind5.masterData.orderStatus.model.action;

import br.com.mind5.masterData.orderStatus.info.OrderatusInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrderatusDaoSelect extends ActionStdTemplateV2<OrderatusInfo> {

	public StdOrderatusDaoSelect(DeciTreeOption<OrderatusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<OrderatusInfo> buildVisitorHook(DeciTreeOption<OrderatusInfo> option) {
		return new VisiOrderatusDaoSelect(option);
	}
}
