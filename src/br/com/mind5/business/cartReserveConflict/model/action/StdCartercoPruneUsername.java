package br.com.mind5.business.cartReserveConflict.model.action;

import br.com.mind5.business.cartReserveConflict.info.CartercoInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCartercoPruneUsername extends ActionStdTemplate<CartercoInfo> {

	public StdCartercoPruneUsername(DeciTreeOption<CartercoInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CartercoInfo> buildVisitorHook(DeciTreeOption<CartercoInfo> option) {
		return new VisiCartercoPruneUsername(option);
	}
}
