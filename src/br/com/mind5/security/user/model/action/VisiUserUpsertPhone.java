package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.phone.info.PhoneInfo;
import br.com.mind5.business.phone.model.decisionTree.RootPhoneUpsertdel;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;

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
