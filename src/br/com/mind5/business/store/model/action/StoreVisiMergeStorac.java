package br.com.mind5.business.store.model.action;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.model.decisionTree.StoracRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StoreVisiMergeStorac extends ActionVisitorTemplateMerge<StoreInfo, StoracInfo> {
	
	public StoreVisiMergeStorac(DeciTreeOption<StoreInfo> option) {
		super(option, StoracInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoracInfo>> getTreeClassHook() {
		return StoracRootSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StoracInfo> selectedInfos) {	
		return StoreMerger.mergeWithStorac(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
