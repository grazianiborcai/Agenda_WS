package br.com.mind5.business.calendarDate.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.info.CalateMerger;
import br.com.mind5.business.calendarDateSearch.info.CalatarchInfo;
import br.com.mind5.business.calendarDateSearch.model.decisionTree.RootCalatarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalateVisiMergeCalatarch extends ActionVisitorTemplateMerge<CalateInfo, CalatarchInfo> {
	
	public CalateVisiMergeCalatarch(DeciTreeOption<CalateInfo> option) {
		super(option, CalatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalatarchInfo>> getTreeClassHook() {
		return RootCalatarchSelect.class;
	}
	
	
	
	@Override protected List<CalateInfo> mergeHook(List<CalateInfo> baseInfos, List<CalatarchInfo> selectedInfos) {	
		return CalateMerger.mergeWithCalatarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
