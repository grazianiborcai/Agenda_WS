package br.com.mind5.business.calendarTimeStore.model.action;

import java.util.List;

import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreMerger;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.StowotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class CalimoreVisiMergeStowotarch extends ActionVisitorTemplateMerge<CalimoreInfo, StowotarchInfo> {
	
	public CalimoreVisiMergeStowotarch(DeciTreeOption<CalimoreInfo> option) {
		super(option, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotarchInfo>> getTreeClassHook() {
		return StowotarchRootSelect.class;
	}
	
	
	
	@Override protected List<CalimoreInfo> mergeHook(List<CalimoreInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return CalimoreMerger.mergeWithStowotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
