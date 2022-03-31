package br.com.mind5.business.storeFavorite.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.info.StoriteMerger;
import br.com.mind5.business.storeFavoriteSearch.info.StoritarchInfo;
import br.com.mind5.business.storeFavoriteSearch.model.decisionTree.RootStoritarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoriteVisiMergeStoritarch extends ActionVisitorTemplateMerge<StoriteInfo, StoritarchInfo> {
	
	public StoriteVisiMergeStoritarch(DeciTreeOption<StoriteInfo> option) {
		super(option, StoritarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoritarchInfo>> getTreeClassHook() {
		return RootStoritarchSelect.class;
	}
	
	
	
	@Override protected List<StoriteInfo> mergeHook(List<StoriteInfo> baseInfos, List<StoritarchInfo> selectedInfos) {	
		return StoriteMerger.mergeWithStoritarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
