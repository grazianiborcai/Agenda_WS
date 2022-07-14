package br.com.mind5.stats.statsStoreOrder.storeOrderDay.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDay.info.StordMerger;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.info.StordiveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderDayLive.model.decisionTree.RootStordiveSelect;

public final class StordVisiMergeStordive extends ActionVisitorTemplateMerge<StordInfo, StordiveInfo> {
	
	public StordVisiMergeStordive(DeciTreeOption<StordInfo> option) {
		super(option, StordiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StordiveInfo>> getTreeClassHook() {
		return RootStordiveSelect.class;
	}
	
	
	
	@Override protected List<StordInfo> mergeHook(List<StordInfo> baseInfos, List<StordiveInfo> selectedInfos) {	
		return StordMerger.mergeWithStordive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
