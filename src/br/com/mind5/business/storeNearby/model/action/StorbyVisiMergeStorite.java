package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.decisionTree.StoriteRootSelectAuth;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeStorite extends ActionVisitorTemplateMerge<StorbyInfo, StoriteInfo> {
	
	public StorbyVisiMergeStorite(DeciTreeOption<StorbyInfo> option) {
		super(option, StoriteInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoriteInfo>> getTreeClassHook() {
		return StoriteRootSelectAuth.class;
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<StoriteInfo> selectedInfos) {	
		return StorbyMerger.mergeWithStorite(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
