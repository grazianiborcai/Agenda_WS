package br.com.mind5.stats.statsUserAccount.userAccountLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveMerger;

final class VisiUseraciveMergeState extends ActionVisitorTemplateMerge<UseraciveInfo, StateInfo> {
	
	public VisiUseraciveMergeState(DeciTreeOption<UseraciveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<UseraciveInfo> mergeHook(List<UseraciveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return UseraciveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
