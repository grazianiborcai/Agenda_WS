package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSearch;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolisMergeAddress extends ActionVisitorTemplateMergeV2<StolisInfo, AddressInfo> {
	
	public VisiStolisMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StolisInfo> baseInfos) {
		return AddressCopier.copyFromStolis(baseInfos);	
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return StolisMerger.mergeWithAddress(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
