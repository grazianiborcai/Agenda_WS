package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveMerger;

final class VisiStoroniveMergeToSelect extends ActionVisitorTemplateMerge<StoroniveInfo, StoroniveInfo> {
	
	public VisiStoroniveMergeToSelect(DeciTreeOption<StoroniveInfo> option) {
		super(option, StoroniveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoroniveInfo>> getActionClassHook() {
		return StdStoroniveDaoSelect.class;
	}
	
	
	
	@Override protected List<StoroniveInfo> mergeHook(List<StoroniveInfo> baseInfos, List<StoroniveInfo> selectedInfos) {	
		return StoroniveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
