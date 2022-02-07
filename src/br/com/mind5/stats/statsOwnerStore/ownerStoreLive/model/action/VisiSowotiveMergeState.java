package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveMerger;

final class VisiSowotiveMergeState extends ActionVisitorTemplateMerge<SowotiveInfo, StateInfo> {
	
	public VisiSowotiveMergeState(DeciTreeOption<SowotiveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<SowotiveInfo> mergeHook(List<SowotiveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return SowotiveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
