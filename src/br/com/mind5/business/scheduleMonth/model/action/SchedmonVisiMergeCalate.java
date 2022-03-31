package br.com.mind5.business.scheduleMonth.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSearch;
import br.com.mind5.business.scheduleMonth.info.SchedmonInfo;
import br.com.mind5.business.scheduleMonth.info.SchedmonMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedmonVisiMergeCalate extends ActionVisitorTemplateMerge<SchedmonInfo, CalateInfo> {
	
	public SchedmonVisiMergeCalate(DeciTreeOption<SchedmonInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSearch.class;
	}
	
	
	
	@Override protected List<SchedmonInfo> mergeHook(List<SchedmonInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return SchedmonMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
