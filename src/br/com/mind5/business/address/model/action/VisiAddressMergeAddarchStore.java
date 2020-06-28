package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.RootAddarchSelectStore;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeAddarchStore extends ActionVisitorTemplateMergeV2<AddressInfo, AddarchInfo> {
	
	public VisiAddressMergeAddarchStore(DeciTreeOption<AddressInfo> option) {
		super(option, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddarchInfo>> getTreeClassHook() {
		return RootAddarchSelectStore.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {	
		return AddressMerger.mergeWithAddarchStore(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
