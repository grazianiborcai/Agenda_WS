package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveMerger;

final class VisiStordiveMergeCalate extends ActionVisitorTemplateMerge<StordiveInfo, CalateInfo> {
	
	public VisiStordiveMergeCalate(DeciTreeOption<StordiveInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelect.class;
	}
	
	
	
	@Override protected List<StordiveInfo> mergeHook(List<StordiveInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return StordiveMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
