package br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.info.SteddiveInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDayLive.model.decisionTree.SteddiveRootSelect;

public final class SteddVisiMergeSteddive extends ActionVisitorTemplateMerge<SteddInfo, SteddiveInfo> {
	
	public SteddVisiMergeSteddive(DeciTreeOption<SteddInfo> option) {
		super(option, SteddiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddiveInfo>> getTreeClassHook() {
		return SteddiveRootSelect.class;
	}
	
	
	
	@Override protected List<SteddInfo> mergeHook(List<SteddInfo> baseInfos, List<SteddiveInfo> selectedInfos) {	
		return SteddMerger.mergeWithSteddive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
