package br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.StateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveInfo;
import br.com.mind5.stats.statsStoreOrder.storeOrderMonthLive.info.StoroniveMerger;

public final class StoroniveVisiMergeState extends ActionVisitorTemplateMerge<StoroniveInfo, StateInfo> {
	
	public StoroniveVisiMergeState(DeciTreeOption<StoroniveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return StateRootSelect.class;
	}
	
	
	
	@Override protected List<StoroniveInfo> mergeHook(List<StoroniveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return StoroniveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
