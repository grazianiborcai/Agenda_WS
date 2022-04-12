package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.SotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeSotarch extends ActionVisitorTemplateMerge<StoreInfo, SotarchInfo> {
	
	public StoreVisiMergeSotarch(DeciTreeOption<StoreInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return SotarchRootSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return StoreMerger.mergeWithSotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
