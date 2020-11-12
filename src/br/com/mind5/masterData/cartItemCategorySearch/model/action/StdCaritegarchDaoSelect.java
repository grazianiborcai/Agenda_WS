package br.com.mind5.masterData.cartItemCategorySearch.model.action;

import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCaritegarchDaoSelect extends ActionStdTemplateV2<CaritegarchInfo> {

	public StdCaritegarchDaoSelect(DeciTreeOption<CaritegarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<CaritegarchInfo> buildVisitorHook(DeciTreeOption<CaritegarchInfo> option) {
		return new VisiCaritegarchDaoSelect(option);
	}
}
