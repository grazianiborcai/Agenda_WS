package br.com.mind5.stats.statsOwnerUser.ownerUserMonth.model.action;

import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.decisionTree.StatarchRootSelectBR;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonth.info.SowusMerger;

public final class SowusVisiMergeStatarch extends ActionVisitorTemplateMerge<SowusInfo, StatarchInfo> {
	
	public SowusVisiMergeStatarch(DeciTreeOption<SowusInfo> option) {
		super(option, StatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StatarchInfo>> getTreeClassHook() {
		return StatarchRootSelectBR.class;
	}
	
	
	
	@Override protected List<SowusInfo> mergeHook(List<SowusInfo> baseInfos, List<StatarchInfo> selectedInfos) {	
		return SowusMerger.mergeWithStatarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
