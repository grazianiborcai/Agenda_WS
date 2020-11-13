package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeToDelete extends ActionVisitorTemplateMerge<AddressInfo, AddressInfo> {
	
	public VisiAddressMergeToDelete(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddressInfo>> getActionClassHook() {
		return StdAddressDaoSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		return AddressMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
