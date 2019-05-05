package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressMergeToDelete extends ActionVisitorTemplateMergeV2<AddressInfo, AddressInfo> {
	
	public VisiAddressMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<AddressInfo> selectedInfos) {
		return AddressMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
