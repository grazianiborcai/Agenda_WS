package br.com.mind5.business.storeLunchTime.model.action;

import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.business.storeLunchTime.info.StuntmMerger;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.masterData.weekday.model.decisionTree.WeekdayRootSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StuntmVisiMergeWeekdayFallback extends ActionVisitorTemplateMerge<StuntmInfo, WeekdayInfo> {
	
	public StuntmVisiMergeWeekdayFallback(DeciTreeOption<StuntmInfo> option) {
		super(option, WeekdayInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<WeekdayInfo>> getTreeClassHook() {
		return WeekdayRootSearch.class;
	}
	
	
	
	@Override protected List<StuntmInfo> mergeHook(List<StuntmInfo> baseInfos, List<WeekdayInfo> selectedInfos) {	
		return StuntmMerger.mergeWithWeekdayFallback(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
