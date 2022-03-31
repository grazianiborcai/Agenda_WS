package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeText.info.StorextCopier;
import br.com.mind5.business.storeText.info.StorextInfo;
import br.com.mind5.business.storeText.model.decisionTree.StorextRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeStorext extends ActionVisitorTemplateMerge<StoreInfo, StorextInfo> {
	
	public StoreVisiMergeStorext(DeciTreeOption<StoreInfo> option) {
		super(option, StorextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorextInfo>> getTreeClassHook() {
		return StorextRootSearch.class;
	}
	
	
	
	@Override protected List<StorextInfo> toActionClassHook(List<StoreInfo> baseInfos) {
		return StorextCopier.copyFromStoreKey(baseInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StorextInfo> selectedInfos) {	
		return StoreMerger.mergeWithStorext(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
