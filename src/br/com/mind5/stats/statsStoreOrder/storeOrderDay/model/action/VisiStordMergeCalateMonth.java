package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarDate.model.decisionTree.CalateRootSelectMonth;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordMerger;

final class VisiStordMergeCalateMonth extends ActionVisitorTemplateMerge<StordInfo, CalateInfo> {
	
	public VisiStordMergeCalateMonth(DeciTreeOption<StordInfo> option) {
		super(option, CalateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CalateInfo>> getTreeClassHook() {
		return CalateRootSelectMonth.class;
	}
	
	
	
	@Override protected List<StordInfo> mergeHook(List<StordInfo> baseInfos, List<CalateInfo> selectedInfos) {	
		return StordMerger.mergeWithCalate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
