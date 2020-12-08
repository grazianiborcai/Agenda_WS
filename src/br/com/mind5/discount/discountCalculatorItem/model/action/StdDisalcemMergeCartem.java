package br.com.mind5.discount.discountCalculatorItem.model.action;

import br.com.mind5.discount.discountCalculatorItem.info.DisalcemInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdDisalcemMergeCartem extends ActionStdTemplate<DisalcemInfo> {

	public StdDisalcemMergeCartem(DeciTreeOption<DisalcemInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<DisalcemInfo> buildVisitorHook(DeciTreeOption<DisalcemInfo> option) {
		return new VisiDisalcemMergeCartem(option);
	}
}
