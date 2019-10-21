package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiAddressMergeForm extends ActionVisitorTemplateMergeV2<AddressInfo, FormAddressInfo> {
	
	public VisiAddressMergeForm(Connection conn, String schemaName) {
		super(conn, schemaName, FormAddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FormAddressInfo>> getTreeClassHook() {
		return RootFormAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<FormAddressInfo> selectedInfos) {
		return AddressMerger.mergeWithForm(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
