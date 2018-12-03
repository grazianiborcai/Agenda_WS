package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneUpsertdel;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiUserUpsertPhone extends ActionVisitorTemplateAction<UserInfo, PhoneInfo> {
	public VisiUserUpsertPhone(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, PhoneInfo.class);
	}
	
	
	
	@Override protected List<PhoneInfo> toActionClassHook(List<UserInfo> recordInfos) {
		List<PhoneInfo> results = new ArrayList<>();
		
		for (UserInfo eachRecord : recordInfos) {
			results.addAll(eachRecord.phones);
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<PhoneInfo> getActionHook(DeciTreeOption<PhoneInfo> option) {
		return new RootPhoneUpsertdel(option).toAction();
	}
}
