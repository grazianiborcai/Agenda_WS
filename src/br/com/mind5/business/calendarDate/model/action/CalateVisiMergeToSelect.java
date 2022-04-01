package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiMergeToSelect extends ActionVisitorTemplateMerge<CalateInfo, CalateInfo> {
	
	public CalateVisiMergeToSelect(DeciTreeOption<CalateInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CalateInfo>> getVisitorClassHook() {
		return CalateVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalateMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
