package br.com.mind5.business.orderItemList.model.action;

import java.util.List;

import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderItemList.model.decisionTree.OrdemistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdemistVisiRootSearch extends ActionVisitorTemplateAction<OrdemistInfo, OrdemistInfo> {

	public OrdemistVisiRootSearch(DeciTreeOption<OrdemistInfo> option) {
		super(option, OrdemistInfo.class, OrdemistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdemistInfo>> getTreeClassHook() {
		return OrdemistRootSearch.class;
	}
	
	
	
	@Override protected List<OrdemistInfo> toBaseClassHook(List<OrdemistInfo> baseInfos, List<OrdemistInfo> results) {
		return results;
	}
}
