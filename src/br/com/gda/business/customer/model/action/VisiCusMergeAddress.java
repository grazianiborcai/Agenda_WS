package br.com.gda.business.customer.model.action;

import java.sql.Connection;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusMergeAddress extends ActionVisitorTemplateMerge<CusInfo, AddressInfo> {
	
	public VisiCusMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CusInfo>> getMergerClassHook() {
		return CusMerger.class;
	}
}
