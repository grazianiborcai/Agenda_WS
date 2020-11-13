package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateMergeToSelect extends ActionVisitorTemplateMerge<CalateInfo, CalateInfo> {
	
	public VisiCalateMergeToSelect(DeciTreeOption<CalateInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CalateInfo>> getActionClassHook() {
		return StdCalateDaoSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalateMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
