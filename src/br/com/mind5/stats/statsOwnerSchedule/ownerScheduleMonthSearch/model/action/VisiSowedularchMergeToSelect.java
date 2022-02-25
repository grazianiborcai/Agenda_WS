package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchMerger;

final class VisiSowedularchMergeToSelect extends ActionVisitorTemplateMerge<SowedularchInfo, SowedularchInfo> {
	
	public VisiSowedularchMergeToSelect(DeciTreeOption<SowedularchInfo> option) {
		super(option, SowedularchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowedularchInfo>> getActionClassHook() {
		return StdSowedularchDaoSelect.class;
	}
	
	
	
	@Override protected List<SowedularchInfo> mergeHook(List<SowedularchInfo> baseInfos, List<SowedularchInfo> selectedInfos) {	
		return SowedularchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
