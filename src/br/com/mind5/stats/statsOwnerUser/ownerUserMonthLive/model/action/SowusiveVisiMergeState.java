package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveMerger;

public final class SowusiveVisiMergeState extends ActionVisitorTemplateMerge<SowusiveInfo, StateInfo> {
	
	public SowusiveVisiMergeState(DeciTreeOption<SowusiveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<SowusiveInfo> mergeHook(List<SowusiveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return SowusiveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
