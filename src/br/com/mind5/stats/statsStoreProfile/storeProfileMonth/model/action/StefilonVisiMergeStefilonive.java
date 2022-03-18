package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonMerger;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.decisionTree.StefiloniveRootSelect;

public final class StefilonVisiMergeStefilonive extends ActionVisitorTemplateMerge<StefilonInfo, StefiloniveInfo> {
	
	public StefilonVisiMergeStefilonive(DeciTreeOption<StefilonInfo> option) {
		super(option, StefiloniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StefiloniveInfo>> getTreeClassHook() {
		return StefiloniveRootSelect.class;
	}
	
	
	
	@Override protected List<StefilonInfo> mergeHook(List<StefilonInfo> baseInfos, List<StefiloniveInfo> selectedInfos) {	
		return StefilonMerger.mergeWithStedmonive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
