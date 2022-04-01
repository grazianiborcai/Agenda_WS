package br.com.mind5.business.calendarTimeStore.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelect;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimoreVisiMergeCalate extends ActionVisitorTemplateMerge<CalimoreInfo, CalateInfo> {
	
	public CalimoreVisiMergeCalate(DeciTreeOption<CalimoreInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelect.class;
	}
	
	
	
	@Override protected List<CalimoreInfo> mergeHook(List<CalimoreInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return CalimoreMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
