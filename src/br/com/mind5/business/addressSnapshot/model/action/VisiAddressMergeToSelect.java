package br.com.mind5.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiAddressMergeToSelect extends ActionVisitorTemplateMerge<AddresnapInfo, AddresnapInfo> {
	
	public VisiAddressMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<AddresnapInfo>> getActionClassHook() {
		return StdAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> recordInfos, List<AddresnapInfo> selectedInfos) {	
		return AddresnapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
