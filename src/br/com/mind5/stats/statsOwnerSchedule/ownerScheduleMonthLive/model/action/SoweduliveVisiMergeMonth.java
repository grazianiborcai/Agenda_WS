package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.month.info.MonthInfo;
import br.com.mind5.masterData.month.model.decisionTree.MonthRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthLive.info.SoweduliveMerger;

public final class SoweduliveVisiMergeMonth extends ActionVisitorTemplateMerge<SoweduliveInfo, MonthInfo> {
	
	public SoweduliveVisiMergeMonth(DeciTreeOption<SoweduliveInfo> option) {
		super(option, MonthInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MonthInfo>> getTreeClassHook() {
		return MonthRootSelect.class;
	}
	
	
	
	@Override protected List<SoweduliveInfo> mergeHook(List<SoweduliveInfo> baseInfos, List<MonthInfo> selectedInfos) {	
		return SoweduliveMerger.mergeWithMonth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
