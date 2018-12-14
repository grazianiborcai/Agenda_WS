package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddressSnapInsert;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertAddressSnap extends ActionVisitorTemplateAction<UserSnapInfo, AddressSnapInfo> {
	public VisiUserSnapInsertAddressSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, AddressSnapInfo.class);
	}
	
	
	
	@Override protected List<AddressSnapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<AddressSnapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			for (AddressSnapInfo eachAddress : eachRecord.addresses) {
				results.add(AddressSnapInfo.copyFrom(eachAddress));
			}
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddressSnapInfo> getActionHook(DeciTreeOption<AddressSnapInfo> option) {
		return new RootAddressSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<AddressSnapInfo> results) {
		return baseInfos;
	}
}
