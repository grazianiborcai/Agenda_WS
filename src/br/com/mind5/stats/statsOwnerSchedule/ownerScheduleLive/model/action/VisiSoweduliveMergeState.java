package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.model.action;

import java.util.List;

import br.com.mind5.masterData.state.info.StateInfo;
import br.com.mind5.masterData.state.model.decisionTree.RootStateSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveInfo;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveMerger;

final class VisiSoweduliveMergeState extends ActionVisitorTemplateMerge<SoweduliveInfo, StateInfo> {
	
	public VisiSoweduliveMergeState(DeciTreeOption<SoweduliveInfo> option) {
		super(option, StateInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StateInfo>> getTreeClassHook() {
		return RootStateSelect.class;
	}
	
	
	
	@Override protected List<SoweduliveInfo> mergeHook(List<SoweduliveInfo> baseInfos, List<StateInfo> selectedInfos) {	
		return SoweduliveMerger.mergeWithState(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
