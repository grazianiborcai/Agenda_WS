package br.com.mind5.stats.statsStoreAccount.storeAccount.model.action;

import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccount.info.StoracMerger;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.info.StoraciveInfo;
import br.com.mind5.stats.statsStoreAccount.storeAccountLive.model.decisionTree.RootStoraciveSelect;

final class VisiStoracMergeStoracive extends ActionVisitorTemplateMerge<StoracInfo, StoraciveInfo> {
	
	public VisiStoracMergeStoracive(DeciTreeOption<StoracInfo> option) {
		super(option, StoraciveInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoraciveInfo>> getTreeClassHook() {
		return RootStoraciveSelect.class;
	}
	
	
	
	@Override protected List<StoracInfo> mergeHook(List<StoracInfo> baseInfos, List<StoraciveInfo> selectedInfos) {	
		return StoracMerger.mergeWithStoracive(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
