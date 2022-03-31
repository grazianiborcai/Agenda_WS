package br.com.mind5.business.storeNearby.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSearch;
import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.business.storeNearby.info.StorbyMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StorbyVisiMergeAddress extends ActionVisitorTemplateMerge<StorbyInfo, AddressInfo> {
	
	public StorbyVisiMergeAddress(DeciTreeOption<StorbyInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StorbyInfo> baseInfos) {		
		return AddressCopier.copyFromStorby(baseInfos);
	}
	
	
	
	@Override protected List<StorbyInfo> mergeHook(List<StorbyInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return StorbyMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
