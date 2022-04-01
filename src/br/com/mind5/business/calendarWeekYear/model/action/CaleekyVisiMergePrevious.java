package br.com.mind5.business.calendarWeekYear.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateCopier;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelectPrevious;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.calendarWeekYear.info.CaleekyMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CaleekyVisiMergePrevious extends ActionVisitorTemplateMerge<CaleekyInfo, CalateInfo> {
	
	public CaleekyVisiMergePrevious(DeciTreeOption<CaleekyInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelectPrevious.class;
	}
	
	
	
	@Override protected List<CalateInfo> toActionClassHook(List<CaleekyInfo> baseInfos) {
		return CalateCopier.copyFromCaleekyPrevious(baseInfos);	
	}
	
	
	
	@Override protected List<CaleekyInfo> mergeHook(List<CaleekyInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CaleekyMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
