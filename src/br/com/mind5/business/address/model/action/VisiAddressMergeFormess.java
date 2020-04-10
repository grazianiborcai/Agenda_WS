package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.business.form.formAddress.model.decisionTree.RootFormessSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddressMergeFormess extends ActionVisitorTemplateMergeV2<AddressInfo, FormessInfo> {
	
	public VisiAddressMergeFormess(DeciTreeOption<AddressInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return RootFormessSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<FormessInfo> selectedInfos) {
		return AddressMerger.mergeWithFormess(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.MERGE_WHEN_EMPTY;
	}
}
