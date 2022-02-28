package br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerSchedule.info.SowedulMerger;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.decisionTree.RootSoweduliveSelect;

final class VisiSowedulMergeSowedulive extends ActionVisitorTemplateMerge<SowedulInfo, SoweduliveInfo> {
	
	public VisiSowedulMergeSowedulive(DeciTreeOption<SowedulInfo> option) {
		super(option, SoweduliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SoweduliveInfo>> getTreeClassHook() {
		return RootSoweduliveSelect.class;
	}
	
	
	
	@Override protected List<SowedulInfo> mergeHook(List<SowedulInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {	
		return SowedulMerger.mergeWithSowedulive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
