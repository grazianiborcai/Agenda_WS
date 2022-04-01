package br.com.mind5.business.calendarDateSearch.model.action;

import java.util.List;

import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.info.CalatarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalatarchVisiMergeToSelect extends ActionVisitorTemplateMerge<CalatarchInfo, CalatarchInfo> {
	
	public CalatarchVisiMergeToSelect(DeciTreeOption<CalatarchInfo> option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<CalatarchInfo>> getVisitorClassHook() {
		return CalatarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<CalatarchInfo> mergeHook(List<CalatarchInfo> baseInfos, List<CalatarchInfo> selectedInfos) {	
		return CalatarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
