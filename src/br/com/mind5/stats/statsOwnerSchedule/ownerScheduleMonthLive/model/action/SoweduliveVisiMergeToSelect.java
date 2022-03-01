package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveMerger;

public final class SoweduliveVisiMergeToSelect extends ActionVisitorTemplateMerge<SoweduliveInfo, SoweduliveInfo> {
	
	public SoweduliveVisiMergeToSelect(DeciTreeOption<SoweduliveInfo> option) {
		super(option, SoweduliveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<SoweduliveInfo>> getVisitorClassHook() {
		return SoweduliveVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<SoweduliveInfo> mergeHook(List<SoweduliveInfo> baseInfos, List<SoweduliveInfo> selectedInfos) {	
		return SoweduliveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
