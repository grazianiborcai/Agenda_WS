package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

final class VisiPayCusUpsertAddress extends ActionVisitorTemplateAction<PayCusInfo, AddressInfo> {
	public VisiPayCusUpsertAddress(Connection conn, String schemaName) {
		super(conn, schemaName, PayCusInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<PayCusInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (PayCusInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.addresses);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressUpsertdel(option).toAction();
	}
}
