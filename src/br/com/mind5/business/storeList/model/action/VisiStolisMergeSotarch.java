package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.RootSotarchSelect;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStolisMergeSotarch extends ActionVisitorTemplateMerge<StolisInfo, SotarchInfo> {
	
	public VisiStolisMergeSotarch(DeciTreeOption<StolisInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return RootSotarchSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return StolisMerger.mergeWithSotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
