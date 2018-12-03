package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiCusUpsertAddress extends ActionVisitorTemplateAction<CusInfo, AddressInfo> {
	public VisiCusUpsertAddress(Connection conn, String schemaName) {
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
		return new RootAddressUpsertdel(option).toAction();
	}
}
