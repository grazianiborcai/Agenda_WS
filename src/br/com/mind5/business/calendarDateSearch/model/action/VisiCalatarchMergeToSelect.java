package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.info.CalatarchMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalatarchMergeToSelect extends ActionVisitorTemplateMergeV2<CalatarchInfo, CalatarchInfo> {
	
	public VisiCalatarchMergeToSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CalatarchInfo>> getActionClassHook() {
		return StdCalatarchDaoSelect.class;
	}
	
	
	
	@Override protected List<CalatarchInfo> mergeHook(List<CalatarchInfo> baseInfos, List<CalatarchInfo> selectedInfos) {	
		return CalatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
