package br.com.mind5.business.calendarCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueMerger;
import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarCatalogueData.model.decisionTree.RootCalguataSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueMergeCalguata extends ActionVisitorTemplateMerge<CalgueInfo, CalguataInfo> {
	
	public VisiCalgueMergeCalguata(DeciTreeOption<CalgueInfo> option) {
		super(option, CalguataInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalguataInfo>> getTreeClassHook() {
		return RootCalguataSelect.class;
	}
	
	
	
	@Override protected List<CalgueInfo> mergeHook(List<CalgueInfo> baseInfos, List<CalguataInfo> selectedInfos) {
		return CalgueMerger.mergeWithCalguata(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
