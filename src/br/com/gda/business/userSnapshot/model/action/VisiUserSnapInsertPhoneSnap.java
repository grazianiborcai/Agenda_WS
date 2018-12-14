package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.business.phoneSnapshot.model.decisionTree.RootPhoneSnapInsert;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserSnapInsertPhoneSnap extends ActionVisitorTemplateAction<UserSnapInfo, PhoneSnapInfo> {
	public VisiUserSnapInsertPhoneSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class, PhoneSnapInfo.class);
	}
	
	
	
	@Override protected List<PhoneSnapInfo> toActionClassHook(List<UserSnapInfo> recordInfos) {
		List<PhoneSnapInfo> results = new ArrayList<>();
		
		for (UserSnapInfo eachRecord : recordInfos) {
			for (PhoneSnapInfo eachPhone : eachRecord.phones) {
				results.add(PhoneSnapInfo.copyFrom(eachPhone));
			}
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneSnapInfo> getActionHook(DeciTreeOption<PhoneSnapInfo> option) {
		return new RootPhoneSnapInsert(option).toAction();
	}
	
	
	
	@Override protected List<UserSnapInfo> toBaseClassHook(List<UserSnapInfo> baseInfos, List<PhoneSnapInfo> results) {
		return baseInfos;
	}
}
