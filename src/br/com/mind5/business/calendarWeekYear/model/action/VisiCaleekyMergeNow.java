package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.RootCalateSelectNow;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.info.CaleekyMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCaleekyMergeNow extends ActionVisitorTemplateMergeV2<CaleekyInfo, CalateInfo> {
	
	public VisiCaleekyMergeNow(DeciTreeOption<CaleekyInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return RootCalateSelectNow.class;
	}
	
	
	
	@Override protected List<CaleekyInfo> mergeHook(List<CaleekyInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CaleekyMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}