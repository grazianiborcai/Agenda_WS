package br.com.mind5.business.storeCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.business.ownerList.model.decisionTree.OwnelisRootSelect;
import br.com.mind5.business.storeCatalogue.info.StogueInfo;
import br.com.mind5.business.storeCatalogue.info.StogueMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StogueVisiMergeOwnelis extends ActionVisitorTemplateMerge<StogueInfo, OwnelisInfo> {
	
	public StogueVisiMergeOwnelis(DeciTreeOption<StogueInfo> option) {
		super(option, OwnelisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnelisInfo>> getTreeClassHook() {
		return OwnelisRootSelect.class;
	}
	
	
	
	@Override protected List<StogueInfo> mergeHook(List<StogueInfo> baseInfos, List<OwnelisInfo> selectedInfos) {	
		return StogueMerger.mergeWithOwnelis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
