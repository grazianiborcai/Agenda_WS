package br.com.mind5.business.cartReserveConflict.model.action;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartercoPruneUsername extends ActionStdTemplateV2<CartercoInfo> {

	public StdCartercoPruneUsername(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CartercoInfo> buildVisitorHook(DeciTreeOption<CartercoInfo> option) {
		return new VisiCartercoPruneUsername(option);
	}
}
