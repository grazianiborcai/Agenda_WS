package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressSearch;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStoreMergeAddress extends ActionVisitorTemplateMergeV2<StoreInfo, AddressInfo> {
	
	public VisiStoreMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return AddressCopier.copyFromStoreKey(recordInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> recordInfos, List<AddressInfo> selectedInfos) {	
		return StoreMerger.mergeWithAddress(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
