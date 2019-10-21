package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.RootAddressDelete;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteAddress extends ActionVisitorTemplateAction<StoreInfo, AddressInfo> {
	public VisiStoreDeleteAddress(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (StoreInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.addresses);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressDelete(option).toAction();
	}
}
