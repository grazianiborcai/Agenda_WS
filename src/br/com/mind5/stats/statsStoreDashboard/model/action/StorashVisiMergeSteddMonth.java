package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.info.StorashMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.info.SteddInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleDay.model.decisionTree.SteddRootSelectMonth;

public final class StorashVisiMergeSteddMonth extends ActionVisitorTemplateMerge<StorashInfo, SteddInfo> {
	
	public StorashVisiMergeSteddMonth(DeciTreeOption<StorashInfo> option) {
		super(option, SteddInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SteddInfo>> getTreeClassHook() {
		return SteddRootSelectMonth.class;
	}
	
	
	
	@Override protected List<StorashInfo> mergeHook(List<StorashInfo> baseInfos, List<SteddInfo> selectedInfos) {	
		return StorashMerger.mergeWithStedd(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
