package br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.model.action;

import java.util.List;

import br.com.mind5.masterData.stateSearch.info.StatarchInfo;
import br.com.mind5.masterData.stateSearch.model.decisionTree.StatarchRootSelectBR;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonth.info.SowotMerger;

public final class SowotVisiMergeStatarch extends ActionVisitorTemplateMerge<SowotInfo, StatarchInfo> {
	
	public SowotVisiMergeStatarch(DeciTreeOption<SowotInfo> option) {
		super(option, StatarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StatarchInfo>> getTreeClassHook() {
		return StatarchRootSelectBR.class;
	}
	
	
	
	@Override protected List<SowotInfo> mergeHook(List<SowotInfo> baseInfos, List<StatarchInfo> selectedInfos) {	
		return SowotMerger.mergeWithStatarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
