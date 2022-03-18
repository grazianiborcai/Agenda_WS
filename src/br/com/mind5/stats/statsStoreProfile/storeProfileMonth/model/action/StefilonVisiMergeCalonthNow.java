package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info.StefilonMerger;

public final class StefilonVisiMergeCalonthNow extends ActionVisitorTemplateMerge<StefilonInfo, CalonthInfo> {
	
	public StefilonVisiMergeCalonthNow(DeciTreeOption<StefilonInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectNow.class;
	}
	
	
	
	@Override protected List<StefilonInfo> mergeHook(List<StefilonInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StefilonMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
