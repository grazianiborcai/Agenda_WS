package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.address.info.AddressCopier;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStoreMergeAddress extends ActionVisitorTemplateMerge<StoreInfo, AddressInfo> {
	
	public VisiStoreMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<StoreInfo>> getMergerClassHook() {
		return StoreMerger.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return AddressCopier.copyFromStore(recordInfos);	
	}
}
