package br.com.mind5.stats.statsStoreDashboard.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.info.StorashMerger;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.info.StedmonInfo;
import br.com.mind5.stats.statsStoreSchedule.storeScheduleMonth.model.decisionTree.StedmonRootSelectLtm;

final class VisiStorashMergeStedmonLtm extends ActionVisitorTemplateMerge<StorashInfo, StedmonInfo> {
	
	public VisiStorashMergeStedmonLtm(DeciTreeOption<StorashInfo> option) {
		super(option, StedmonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StedmonInfo>> getTreeClassHook() {
		return StedmonRootSelectLtm.class;
	}
	
	
	
	@Override protected List<StorashInfo> mergeHook(List<StorashInfo> baseInfos, List<StedmonInfo> selectedInfos) {	
		return StorashMerger.mergeWithStedmonLtm(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
