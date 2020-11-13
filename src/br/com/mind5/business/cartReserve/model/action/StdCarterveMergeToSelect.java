package br.com.mind5.business.cartReserve.model.action;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCarterveMergeToSelect extends ActionStdTemplate<CarterveInfo> {

	public StdCarterveMergeToSelect(DeciTreeOption<CarterveInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CarterveInfo> buildVisitorHook(DeciTreeOption<CarterveInfo> option) {
		return new VisiCarterveMergeToSelect(option);
	}
}
