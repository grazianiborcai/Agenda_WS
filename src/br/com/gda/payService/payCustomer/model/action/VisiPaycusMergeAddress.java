package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;

final class VisiPaycusMergeAddress extends ActionVisitorTemplateMerge_<PaycusInfo, AddressInfo> {
	
	public VisiPaycusMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PaycusInfo>> getMergerClassHook() {
		return PaycusMerger.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PaycusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (PaycusInfo eachRecord : recordInfos) {
			AddressInfo address = new AddressInfo();
			address.codOwner = eachRecord.codOwner;
			address.codPayCustomer = eachRecord.codPayCustomer;
			results.add(address);
		}		
		
		return results;
	}
}
