package br.com.mind5.business.calendarCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueMerger;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueMergeCalate extends ActionVisitorTemplateMergeV2<CalgueInfo, CalateInfo> {
	
	public VisiCalgueMergeCalate(DeciTreeOption<CalgueInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSearch.class;
	}
	
	
	
	@Override protected List<CalgueInfo> mergeHook(List<CalgueInfo> baseInfos, List<CalateInfo> selectedInfos) {
		return CalgueMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
