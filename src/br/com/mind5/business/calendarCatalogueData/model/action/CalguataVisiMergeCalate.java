package br.com.mind5.business.calendarCatalogueData.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.info.CalguataMerger;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalguataVisiMergeCalate extends ActionVisitorTemplateMerge<CalguataInfo, CalateInfo> {
	
	public CalguataVisiMergeCalate(DeciTreeOption<CalguataInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSearch.class;
	}
	
	
	
	@Override protected List<CalguataInfo> mergeHook(List<CalguataInfo> baseInfos, List<CalateInfo> selectedInfos) {
		return CalguataMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
