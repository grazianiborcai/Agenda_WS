package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeForm extends ActionVisitorTemplateMergeV2<AddressInfo, FormAddressInfo> {
	
	public VisiAddressMergeForm(DeciTreeOption<AddressInfo> option) {
		super(option, FormAddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormAddressInfo>> getTreeClassHook() {
		return RootFormAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<FormAddressInfo> selectedInfos) {
		return AddressMerger.mergeWithForm(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
