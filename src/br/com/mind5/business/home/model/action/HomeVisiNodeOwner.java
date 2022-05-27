package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.model.decisionTree.HomeNodeOwner;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class HomeVisiNodeOwner extends ActionVisitorTemplateAction<HomeInfo, HomeInfo> {

	public HomeVisiNodeOwner(DeciTreeOption<HomeInfo> option) {
		super(option, HomeInfo.class, HomeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<HomeInfo>> getTreeClassHook() {
		return HomeNodeOwner.class;
	}
	
	
	
	@Override protected List<HomeInfo> toBaseClassHook(List<HomeInfo> baseInfos, List<HomeInfo> results) {
		return results;
	}
}
