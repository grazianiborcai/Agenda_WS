package br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarMonth.info.CalonthInfo;
import br.com.mind5.business.calendarMonth.model.decisionTree.CalonthRootSelectLtmNow;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonMerger;

public final class StedmonVisiMergeCalonthLtm extends ActionVisitorTemplateMerge<StedmonInfo, CalonthInfo> {
	
	public StedmonVisiMergeCalonthLtm(DeciTreeOption<StedmonInfo> option) {
		super(option, CalonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalonthInfo>> getTreeClassHook() {
		return CalonthRootSelectLtmNow.class;
	}
	
	
	
	@Override protected List<StedmonInfo> mergeHook(List<StedmonInfo> baseInfos, List<CalonthInfo> selectedInfos) {	
		return StedmonMerger.mergeWithCalonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
