package br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveMerger;

final class VisiSteddiveMergeToSelect extends ActionVisitorTemplateMerge<SteddiveInfo, SteddiveInfo> {
	
	public VisiSteddiveMergeToSelect(DeciTreeOption<SteddiveInfo> option) {
		super(option, SteddiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<SteddiveInfo>> getActionClassHook() {
		return StdSteddiveDaoSelect.class;
	}
	
	
	
	@Override protected List<SteddiveInfo> mergeHook(List<SteddiveInfo> baseInfos, List<SteddiveInfo> selectedInfos) {	
		return SteddiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
