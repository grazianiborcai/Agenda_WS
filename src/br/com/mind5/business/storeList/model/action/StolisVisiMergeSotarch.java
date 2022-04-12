package br.com.mind5.business.storeList.model.action;

import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.business.storeSearch.model.decisionTree.SotarchRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StolisVisiMergeSotarch extends ActionVisitorTemplateMerge<StolisInfo, SotarchInfo> {
	
	public StolisVisiMergeSotarch(DeciTreeOption<StolisInfo> option) {
		super(option, SotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SotarchInfo>> getTreeClassHook() {
		return SotarchRootSelect.class;
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<SotarchInfo> selectedInfos) {	
		return StolisMerger.mergeWithSotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
