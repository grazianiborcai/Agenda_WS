package br.com.mind5.business.calendarDateAvailability.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSearch;
import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.calendarDateAvailability.info.CalatityMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalatityMergeCalate extends ActionVisitorTemplateMerge<CalatityInfo, CalateInfo> {
	
	public VisiCalatityMergeCalate(DeciTreeOption<CalatityInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSearch.class;
	}
	
	
	
	@Override protected List<CalatityInfo> mergeHook(List<CalatityInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalatityMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
