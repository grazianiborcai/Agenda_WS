package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

final class VisiPaycusUpsertAddress extends ActionVisitorTemplateAction<PaycusInfo, AddressInfo> {
	public VisiPaycusUpsertAddress(Connection conn, String schemaName) {
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
		return new RootAddressUpsertdel(option).toAction();
	}
}
