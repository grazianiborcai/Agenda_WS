package br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveMerger;

final class VisiStordiveMergeToSelect extends ActionVisitorTemplateMerge<StordiveInfo, StordiveInfo> {
	
	public VisiStordiveMergeToSelect(DeciTreeOption<StordiveInfo> option) {
		super(option, StordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StordiveInfo>> getActionClassHook() {
		return StdStordiveDaoSelect.class;
	}
	
	
	
	@Override protected List<StordiveInfo> mergeHook(List<StordiveInfo> baseInfos, List<StordiveInfo> selectedInfos) {	
		return StordiveMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
