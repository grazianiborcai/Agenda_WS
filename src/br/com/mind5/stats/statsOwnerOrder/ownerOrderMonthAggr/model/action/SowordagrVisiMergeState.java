package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.StateRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrInfo;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthAggr.info.SowordagrMerger;

public final class SowordagrVisiMergeState extends ActionVisitorTemplateMerge<SowordagrInfo, StateInfo> {
	
	public SowordagrVisiMergeState(DeciTreeOption<SowordagrInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return StateRootSelect.class;
	}
	
	
	
	@Override protected List<SowordagrInfo> mergeHook(List<SowordagrInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return SowordagrMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
