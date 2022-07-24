package br.com.mind5.masterData.cartItemCategorySearch.model;

import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;
import br.com.mind5.masterData.cartItemCategorySearch.model.decisionTree.CaritegarchRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CaritegarchModelSelect extends ModelTemplate<CaritegarchInfo> {

	public CaritegarchModelSelect(CaritegarchInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<CaritegarchInfo> getDecisionTreeHook(DeciTreeOption<CaritegarchInfo> option) {
		return new CaritegarchRootSelect(option);
	}
}
