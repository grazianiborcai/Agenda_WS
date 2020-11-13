package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.addressDefault.info.AddaultInfo;
import br.com.mind5.business.addressDefault.model.decisionTree.RootAddaultSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeAddault extends ActionVisitorTemplateMerge<AddressInfo, AddaultInfo> {
	
	public VisiAddressMergeAddault(DeciTreeOption<AddressInfo> option) {
		super(option, AddaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddaultInfo>> getTreeClassHook() {
		return RootAddaultSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<AddaultInfo> selectedInfos) {	
		return AddressMerger.mergeWithAddault(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
