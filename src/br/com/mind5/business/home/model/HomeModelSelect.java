package br.com.mind5.business.home.model;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.model.decisionTree.HomeRootSelect;
import br.com.mind5.model.ModelTemplate;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class HomeModelSelect extends ModelTemplate<HomeInfo> {

	public HomeModelSelect(HomeInfo recordInfo) {
		super(recordInfo);
	}
	
	
	
	@Override protected DeciTree<HomeInfo> getDecisionTreeHook(DeciTreeOption<HomeInfo> option) {
		return new HomeRootSelect(option);
	}
}
