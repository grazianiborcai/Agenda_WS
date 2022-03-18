package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveMerger;

public final class StefiloniveVisiMergeCalonth extends ActionVisitorTemplateMerge<StefiloniveInfo, CalonthInfo> {
	
	public StefiloniveVisiMergeCalonth(DeciTreeOption<StefiloniveInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelect.class;
	}
	
	
	
	@Override protected List<StefiloniveInfo> mergeHook(List<StefiloniveInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StefiloniveMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
