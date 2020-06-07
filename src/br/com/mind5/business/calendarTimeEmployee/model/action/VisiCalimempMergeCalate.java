package br.com.mind5.business.calendarTimeEmployee.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSelect;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempInfo;
import br.com.mind5.business.calendarTimeEmployee.info.CalimempMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCalimempMergeCalate extends ActionVisitorTemplateMergeV2<CalimempInfo, CalateInfo> {
	
	public VisiCalimempMergeCalate(DeciTreeOption<CalimempInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSelect.class;
	}
	
	
	
	@Override protected List<CalimempInfo> mergeHook(List<CalimempInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalimempMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
