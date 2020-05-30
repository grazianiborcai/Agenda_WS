package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalateMergeToSelect extends ActionVisitorTemplateMergeV2<CalateInfo, CalateInfo> {
	
	public VisiCalateMergeToSelect(DeciTreeOption<CalateInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CalateInfo>> getActionClassHook() {
		return StdCalateDaoSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalateMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
