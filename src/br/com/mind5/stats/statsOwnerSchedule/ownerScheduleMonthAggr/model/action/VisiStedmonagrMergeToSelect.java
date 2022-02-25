package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleMonthAggr.info.SowedulagrMerger;

final class VisiStedmonagrMergeToSelect extends ActionVisitorTemplateMerge<SowedulagrInfo, SowedulagrInfo> {
	
	public VisiStedmonagrMergeToSelect(DeciTreeOption<SowedulagrInfo> option) {
		super(option, SowedulagrInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SowedulagrInfo>> getActionClassHook() {
		return StdStedmonagrDaoSelect.class;
	}
	
	
	
	@Override protected List<SowedulagrInfo> mergeHook(List<SowedulagrInfo> baseInfos, List<SowedulagrInfo> selectedInfos) {	
		return SowedulagrMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
