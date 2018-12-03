package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.decisionTree.RootAddressUpsertdel;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserUpsertAddress extends ActionVisitorTemplateAction<UserInfo, AddressInfo> {
	public VisiUserUpsertAddress(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, AddressInfo.class);
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<UserInfo> recordInfos) {
		List<AddressInfo> results = new ArrayList<>();
		
		for (UserInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.addresses);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressInfo> getActionHook(DeciTreeOption<AddressInfo> option) {
		return new RootAddressUpsertdel(option).toAction();
	}
}
