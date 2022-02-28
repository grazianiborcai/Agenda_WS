package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveMerger;

final class VisiSoweduliveMergeToSelect extends ActionVisitorTemplateMerge<SoweduliveInfo, SoweduliveInfo> {
	
	public VisiSoweduliveMergeToSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option, SoweduliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SoweduliveInfo>> getActionClassHook() {
		return StdSoweduliveDaoSelect.class;
	}
	
	
	
	@Override protected List<SoweduliveInfo> mergeHook(List<SoweduliveInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {	
		return SoweduliveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
