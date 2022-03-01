package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.info.SowedularchInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthSearch.model.decisionTree.SowedularchRootSelectMonth;

public final class SowedulagrVisiMergeSowedularchMonth extends ActionVisitorTemplateMerge<SowedulagrInfo, SowedularchInfo> {
	
	public SowedulagrVisiMergeSowedularchMonth(DeciTreeOption<SowedulagrInfo> option) {
		super(option, SowedularchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowedularchInfo>> getTreeClassHook() {
		return SowedularchRootSelectMonth.class;
	}
	
	
	
	@Override protected List<SowedulagrInfo> mergeHook(List<SowedulagrInfo> baseInfos, List<SowedularchInfo> selectedInfos) {	
		return SowedulagrMerger.mergeWithSowedularch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
