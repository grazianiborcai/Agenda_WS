package br.com.mind5.business.home.model.action;

import java.util.List;

import br.com.mind5.business.home.info.HomeInfo;
import br.com.mind5.business.home.info.HomeMerger;
import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.model.decisionTree.StomanRootSelectAuth;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class HomeVisiMergeStoman extends ActionVisitorTemplateMerge<HomeInfo, StomanInfo> {
	
	public HomeVisiMergeStoman(DeciTreeOption<HomeInfo> option) {
		super(option, StomanInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StomanInfo>> getTreeClassHook() {
		return StomanRootSelectAuth.class;
	}
	
	
	
	@Override protected List<HomeInfo> mergeHook(List<HomeInfo> baseInfos, List<StomanInfo> selectedInfos) {	
		return HomeMerger.mergeWithStoman(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
