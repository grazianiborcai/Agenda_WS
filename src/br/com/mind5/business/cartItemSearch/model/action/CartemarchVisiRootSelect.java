package br.com.mind5.business.cartItemSearch.model.action;

import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.decisionTree.CartemarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CartemarchVisiRootSelect extends ActionVisitorTemplateAction<CartemarchInfo, CartemarchInfo> {

	public CartemarchVisiRootSelect(DeciTreeOption<CartemarchInfo> option) {
		super(option, CartemarchInfo.class, CartemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartemarchInfo>> getTreeClassHook() {
		return CartemarchRootSelect.class;
	}
	
	
	
	@Override protected List<CartemarchInfo> toBaseClassHook(List<CartemarchInfo> baseInfos, List<CartemarchInfo> results) {
		return results;
	}
}
