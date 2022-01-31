package br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveMerger;

final class VisiStoraciveMergeState extends ActionVisitorTemplateMerge<StoraciveInfo, StateInfo> {
	
	public VisiStoraciveMergeState(DeciTreeOption<StoraciveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<StoraciveInfo> mergeHook(List<StoraciveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return StoraciveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
