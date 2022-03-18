package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonMerger;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.decisionTree.StefilonagrRootSelect;

public final class StefilonVisiMergeStefilonagr extends ActionVisitorTemplateMerge<StefilonInfo, StefilonagrInfo> {
	
	public StefilonVisiMergeStefilonagr(DeciTreeOption<StefilonInfo> option) {
		super(option, StefilonagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefilonagrInfo>> getTreeClassHook() {
		return StefilonagrRootSelect.class;
	}
	
	
	
	@Override protected List<StefilonInfo> mergeHook(List<StefilonInfo> baseInfos, List<StefilonagrInfo> selectedInfos) {	
		return StefilonMerger.mergeWithStedmonagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
