package br.com.mind5.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateActionV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdDelete;

final class VisiUserDeleteUpswd extends ActionVisitorTemplateActionV1<UserInfo, UpswdInfo> {
	public VisiUserDeleteUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected List<UpswdInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return UpswdInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdDelete(option).toAction();
	}
}
