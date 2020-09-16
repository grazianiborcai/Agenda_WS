package br.com.mind5.business.calendarCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.calendarCatalogue.info.CalgueInfo;
import br.com.mind5.business.calendarCatalogue.info.CalgueMerger;
import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.calendarDateAvailability.model.decisionTree.RootCalatitySearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalgueMergeCalatity extends ActionVisitorTemplateMergeV2<CalgueInfo, CalatityInfo> {
	
	public VisiCalgueMergeCalatity(DeciTreeOption<CalgueInfo> option) {
		super(option, CalatityInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalatityInfo>> getTreeClassHook() {
		return RootCalatitySearch.class;
	}
	
	
	
	@Override protected List<CalgueInfo> mergeHook(List<CalgueInfo> baseInfos, List<CalatityInfo> selectedInfos) {
		return CalgueMerger.mergeWithCalatity(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}