package br.com.gda.business.userSnapshot_.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddresnapInsert;
import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertAddressSnap extends ActionVisitorTemplateAction<UserSnapInfo, AddresnapInfo> {
	public VisiUserSnapInsertAddressSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, AddresnapInfo.class);
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<AddresnapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			for (AddresnapInfo eachAddress : eachRecord.addresses) {
				results.add(AddresnapInfo.copyFrom(eachAddress));
			}
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<AddresnapInfo> getActionHook(DeciTreeOption<AddresnapInfo> option) {
		return new RootAddresnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<AddresnapInfo> results) {
		return baseInfos;
	}
}
