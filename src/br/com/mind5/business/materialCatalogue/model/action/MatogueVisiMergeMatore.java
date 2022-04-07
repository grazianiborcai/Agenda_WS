package br.com.mind5.business.materialCatalogue.model.action;

import java.util.List;

import br.com.mind5.business.materialCatalogue.info.MatogueInfo;
import br.com.mind5.business.materialCatalogue.info.MatogueMerger;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.decisionTree.RootMatoreSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class MatogueVisiMergeMatore extends ActionVisitorTemplateMerge<MatogueInfo, MatoreInfo> {
	
	public MatogueVisiMergeMatore(DeciTreeOption<MatogueInfo> option) {
		super(option, MatoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatoreInfo>> getTreeClassHook() {
		return RootMatoreSearch.class;
	}
	
	
	
	@Override protected List<MatogueInfo> mergeHook(List<MatogueInfo> baseInfos, List<MatoreInfo> selectedInfos) {	
		return MatogueMerger.mergeWithMatore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
