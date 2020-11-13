package br.com.mind5.masterData.cartItemCategorySearch.model.action;

import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaritegarchDaoSelect extends ActionStdTemplate<CaritegarchInfo> {

	public StdCaritegarchDaoSelect(DeciTreeOption<CaritegarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CaritegarchInfo> buildVisitorHook(DeciTreeOption<CaritegarchInfo> option) {
		return new VisiCaritegarchDaoSelect(option);
	}
}
