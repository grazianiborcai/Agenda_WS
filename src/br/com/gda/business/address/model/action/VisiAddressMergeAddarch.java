package br.com.gda.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.info.AddressMerger;
import br.com.gda.business.addressSearch.info.AddarchInfo;
import br.com.gda.business.addressSearch.model.decisionTree.RootAddarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddressMergeAddarch extends ActionVisitorTemplateMergeV2<AddressInfo, AddarchInfo> {
	
	public VisiAddressMergeAddarch(Connection conn, String schemaName) {
		super(conn, schemaName, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddarchInfo>> getTreeClassHook() {
		return RootAddarchSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> recordInfos, List<AddarchInfo> selectedInfos) {	
		return AddressMerger.mergeWithAddarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
