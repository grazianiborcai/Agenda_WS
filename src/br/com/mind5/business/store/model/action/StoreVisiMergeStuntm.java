package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.model.decisionTree.StuntmRootSearchStoreFallback;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeStuntm extends ActionVisitorTemplateMerge<StoreInfo, StuntmInfo> {
	
	public StoreVisiMergeStuntm(DeciTreeOption<StoreInfo> option) {
		super(option, StuntmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StuntmInfo>> getTreeClassHook() {
		return StuntmRootSearchStoreFallback.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StuntmInfo> selectedInfos) {	
		return StoreMerger.mergeWithStuntm(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
