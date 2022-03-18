package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.decisionTree.StefilonRootSelectNow;

public final class StoreVisiMergeStefilon extends ActionVisitorTemplateMerge<StoreInfo, StefilonInfo> {
	
	public StoreVisiMergeStefilon(DeciTreeOption<StoreInfo> option) {
		super(option, StefilonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonInfo>> getTreeClassHook() {
		return StefilonRootSelectNow.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StefilonInfo> selectedInfos) {	
		return StoreMerger.mergeWithStefilon(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
