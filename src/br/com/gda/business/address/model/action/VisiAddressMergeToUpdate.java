package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiAddressMergeToUpdate extends ActionVisitorTemplateMergeV2<AddressInfo, AddressInfo> {
	
	public VisiAddressMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<AddressInfo>> getActionClassHook() {
		return StdAddressSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<AddressInfo> selectedInfos) {	
		return AddressMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
