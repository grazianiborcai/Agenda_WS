package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PayCusInfo;
import br.com.gda.payService.payCustomer.info.PayCusMerger;

final class VisiPayCusMergeAddress extends ActionVisitorTemplateMerge<PayCusInfo, AddressInfo> {
	
	public VisiPayCusMergeAddress(Connection conn, String schemaName) {
		super(conn, schemaName, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return RootAddressSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayCusInfo>> getMergerClassHook() {
		return PayCusMerger.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			AddressInfo address = new AddressInfo();
			address.codOwner = eachRecord.codOwner;
			address.codPayCustomer = eachRecord.codPayCustomer;
			results.add(address);
		}		
		
		return results;
	}
}
