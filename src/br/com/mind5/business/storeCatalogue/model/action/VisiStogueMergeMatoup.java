package br.com.mind5.business.storeCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.info.StogueMerger;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;
import br.com.mind5.masterData.materialGroup.model.decisionTree.RootMatoupSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStogueMergeMatoup extends ActionVisitorTemplateMergeV2<StogueInfo, MatoupInfo> {
	
	public VisiStogueMergeMatoup(DeciTreeOption<StogueInfo> option) {
		super(option, MatoupInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoupInfo>> getTreeClassHook() {
		return RootMatoupSearch.class;
	}
	
	
	
	@Override protected List<StogueInfo> mergeHook(List<StogueInfo> baseInfos, List<MatoupInfo> selectedInfos) {	
		return StogueMerger.mergeWithMatoup(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
