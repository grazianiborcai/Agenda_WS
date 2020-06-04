package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.info.CaleekyMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaleekyMergeToSelect extends ActionVisitorTemplateMergeV2<CaleekyInfo, CaleekyInfo> {
	
	public VisiCaleekyMergeToSelect(DeciTreeOption<CaleekyInfo> option) {
		super(option, CaleekyInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<CaleekyInfo>> getActionClassHook() {
		return StdCaleekyDaoSelect.class;
	}
	
	
	
	@Override protected List<CaleekyInfo> mergeHook(List<CaleekyInfo> baseInfos, List<CaleekyInfo> selectedInfos) {	
		return CaleekyMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
