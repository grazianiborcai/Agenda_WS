package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.cartCounter.info.CartouInfo;
import br.com.mind5.business.cartCounter.model.decisionTree.RootCartouSelect;
import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiHomeMergeCartou extends ActionVisitorTemplateMerge<HomeInfo, CartouInfo> {
	
	public VisiHomeMergeCartou(DeciTreeOption<HomeInfo> option) {
		super(option, CartouInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartouInfo>> getTreeClassHook() {
		return RootCartouSelect.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<CartouInfo> selectedInfos) {	
		return HomeMerger.mergeWithCartou(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
