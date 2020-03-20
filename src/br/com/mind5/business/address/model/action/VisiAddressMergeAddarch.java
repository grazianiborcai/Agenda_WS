package br.com.mind5.business.address.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.info.AddressMerger;
import br.com.mind5.business.addressSearch.info.AddarchInfo;
import br.com.mind5.business.addressSearch.model.decisionTree.RootAddarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiAddressMergeAddarch extends ActionVisitorTemplateMergeV2<AddressInfo, AddarchInfo> {
	
	public VisiAddressMergeAddarch(Connection conn, String schemaName) {
		super(conn, schemaName, AddarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddarchInfo>> getTreeClassHook() {
		return RootAddarchSelect.class;
	}
	
	
	
	@Override protected List<AddressInfo> mergeHook(List<AddressInfo> baseInfos, List<AddarchInfo> selectedInfos) {	
		return AddressMerger.mergeWithAddarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
