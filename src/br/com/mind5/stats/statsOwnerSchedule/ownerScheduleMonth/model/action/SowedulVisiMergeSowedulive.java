package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonth.info.SowedulMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.decisionTree.SoweduliveRootSelect;

public final class SowedulVisiMergeSowedulive extends ActionVisitorTemplateMerge<SowedulInfo, SoweduliveInfo> {
	
	public SowedulVisiMergeSowedulive(DeciTreeOption<SowedulInfo> option) {
		super(option, SoweduliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SoweduliveInfo>> getTreeClassHook() {
		return SoweduliveRootSelect.class;
	}
	
	
	
	@Override protected List<SowedulInfo> mergeHook(List<SowedulInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {	
		return SowedulMerger.mergeWithSowedulive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
