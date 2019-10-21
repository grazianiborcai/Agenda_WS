package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userPassword.info.UpswdCopier;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdInsertRandom;

final class VisiUserInsertUpswd extends ActionVisitorTemplateAction<UserInfo, UpswdInfo> {
	public VisiUserInsertUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected List<UpswdInfo> toActionClassHook(List<UserInfo> recordInfos) {
		List<UpswdInfo> results = new ArrayList<>();
		
		for (UserInfo eachRecord : recordInfos) {
			results.add(UpswdCopier.copyFromUser(eachRecord));
		}		
		
		return results;
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdInsertRandom(option).toAction();
	}
	
	
	
	@Override protected List<UserInfo> toBaseClassHook(List<UserInfo> baseInfos, List<UpswdInfo> results) {
		return baseInfos;
	}
}
