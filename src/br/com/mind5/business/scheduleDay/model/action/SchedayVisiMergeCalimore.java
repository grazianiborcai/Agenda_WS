package br.com.mind5.business.scheduleDay.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.model.decisionTree.CalimoreRootSelect;
import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.business.scheduleDay.info.SchedayMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class SchedayVisiMergeCalimore extends ActionVisitorTemplateMerge<SchedayInfo, CalimoreInfo> {
	
	public SchedayVisiMergeCalimore(DeciTreeOption<SchedayInfo> option) {
		super(option, CalimoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalimoreInfo>> getTreeClassHook() {
		return CalimoreRootSelect.class;
	}
	
	
	
	@Override protected List<SchedayInfo> mergeHook(List<SchedayInfo> baseInfos, List<CalimoreInfo> selectedInfos) {	
		return SchedayMerger.mergeWithCalimore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
