package br.com.mind5.business.storeCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.info.StogueMerger;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.model.decisionTree.RootStorbySelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStogueMergeStorby extends ActionVisitorTemplateMergeV2<StogueInfo, StorbyInfo> {
	
	public VisiStogueMergeStorby(DeciTreeOption<StogueInfo> option) {
		super(option, StorbyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StorbyInfo>> getTreeClassHook() {
		return RootStorbySelect.class;
	}
	
	
	
	@Override protected List<StogueInfo> mergeHook(List<StogueInfo> baseInfos, List<StorbyInfo> selectedInfos) {	
		return StogueMerger.mergeStorby(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
