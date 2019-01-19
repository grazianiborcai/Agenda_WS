package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressDelete;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class VisiPaycusDeleteAddress extends ActionVisitorTemplateAction<PaycusInfo, AddressInfo> {
	public VisiPaycusDeleteAddress(Connection conn, String schemaName) {
		super(conn, schemaName, PaycusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PaycusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (PaycusInfo eachRecord : recordInfos) {
			results.add(eachRecord.address);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressDelete(option).toAction();
	}
}
