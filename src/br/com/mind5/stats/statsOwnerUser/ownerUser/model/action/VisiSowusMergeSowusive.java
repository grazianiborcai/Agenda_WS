package br.com.mind5.stats.statsOwnerUser.ownerUser.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUser.info.SowusMerger;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.model.decisionTree.RootSowusiveSelect;

final class VisiSowusMergeSowusive extends ActionVisitorTemplateMerge<SowusInfo, SowusiveInfo> {
	
	public VisiSowusMergeSowusive(DeciTreeOption<SowusInfo> option) {
		super(option, SowusiveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SowusiveInfo>> getTreeClassHook() {
		return RootSowusiveSelect.class;
	}
	
	
	
	@Override protected List<SowusInfo> mergeHook(List<SowusInfo> baseInfos, List<SowusiveInfo> selectedInfos) {	
		return SowusMerger.mergeWithStoracive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
