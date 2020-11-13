package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.info.CalatarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalatarchMergeToSelect extends ActionVisitorTemplateMerge<CalatarchInfo, CalatarchInfo> {
	
	public VisiCalatarchMergeToSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CalatarchInfo>> getActionClassHook() {
		return StdCalatarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CalatarchInfo> mergeHook(List<CalatarchInfo> baseInfos, List<CalatarchInfo> selectedInfos) {	
		return CalatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
