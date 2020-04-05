package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeToDelete extends ActionVisitorTemplateMergeV2<AddressInfo, AddressInfo> {
	
	public VisiAddressMergeToDelete(DeciTreeOption<AddressInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV2<AddressInfo>> getActionClassHook() {
		return StdAddressDaoSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<AddressInfo> selectedInfos) {
		return AddressMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
