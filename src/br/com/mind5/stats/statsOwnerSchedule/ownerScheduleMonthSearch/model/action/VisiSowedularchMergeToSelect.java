package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchhInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchMerger;

final class VisiSowedularchMergeToSelect extends ActionVisitorTemplateMerge<SowedularchhInfo, SowedularchhInfo> {
	
	public VisiSowedularchMergeToSelect(DeciTreeOption<SowedularchhInfo> option) {
		super(option, SowedularchhInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowedularchhInfo>> getActionClassHook() {
		return StdSowedularchDaoSelect.class;
	}
	
	
	
	@Override protected List<SowedularchhInfo> mergeHook(List<SowedularchhInfo> baseInfos, List<SowedularchhInfo> selectedInfos) {	
		return SowedularchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
