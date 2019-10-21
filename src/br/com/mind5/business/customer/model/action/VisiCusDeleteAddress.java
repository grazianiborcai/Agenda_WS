package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressDelete;
import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiCusDeleteAddress extends ActionVisitorTemplateAction<CusInfo, AddressInfo> {
	public VisiCusDeleteAddress(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<CusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (CusInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.addresses);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressDelete(option).toAction();
	}
}
