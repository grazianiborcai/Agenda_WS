package br.com.mind5.masterData.cartItemCategory.model.action;

import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaritegDaoSelect extends ActionStdTemplate<CaritegInfo> {

	public StdCaritegDaoSelect(DeciTreeOption<CaritegInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CaritegInfo> buildVisitorHook(DeciTreeOption<CaritegInfo> option) {
		return new VisiCaritegDaoSelect(option);
	}
}
