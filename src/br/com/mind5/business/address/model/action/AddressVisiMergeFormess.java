package br.com.mind5.business.address.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.form.formAddress.info.FormessInfo;
import br.com.mind5.form.formAddress.model.decisionTree.FormessRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddressVisiMergeFormess extends ActionVisitorTemplateMerge<AddressInfo, FormessInfo> {
	
	public AddressVisiMergeFormess(DeciTreeOption<AddressInfo> option) {
		super(option, FormessInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormessInfo>> getTreeClassHook() {
		return FormessRootSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<FormessInfo> selectedInfos) {
		return AddressMerger.mergeWithFormess(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
