package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.business.form.formAddress.model.decisionTree.RootFormAddressSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
