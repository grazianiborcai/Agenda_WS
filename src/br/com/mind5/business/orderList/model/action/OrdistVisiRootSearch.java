package br.com.mind5.business.orderList.model.action;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.model.decisionTree.OrdistRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class OrdistVisiRootSearch extends ActionVisitorTemplateAction<OrdistInfo, OrdistInfo> {

	public OrdistVisiRootSearch(DeciTreeOption<OrdistInfo> option) {
		super(option, OrdistInfo.class, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrdistInfo>> getTreeClassHook() {
		return OrdistRootSearch.class;
	}
	
	
	
	@Override protected List<OrdistInfo> toBaseClassHook(List<OrdistInfo> baseInfos, List<OrdistInfo> results) {
		return results;
	}
}
