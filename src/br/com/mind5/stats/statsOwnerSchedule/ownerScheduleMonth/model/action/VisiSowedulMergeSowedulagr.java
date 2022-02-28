package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.decisionTree.RootSowedulagrSelect;

final class VisiSowedulMergeSowedulagr extends ActionVisitorTemplateMerge<SowedulInfo, SowedulagrInfo> {
	
	public VisiSowedulMergeSowedulagr(DeciTreeOption<SowedulInfo> option) {
		super(option, SowedulagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedulagrInfo>> getTreeClassHook() {
		return RootSowedulagrSelect.class;
	}
	
	
	
	@Override protected List<SowedulInfo> mergeHook(List<SowedulInfo> baseInfos, List<SowedulagrInfo> selectedInfos) {	
		return SowedulMerger.mergeWithSowedulagr(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
