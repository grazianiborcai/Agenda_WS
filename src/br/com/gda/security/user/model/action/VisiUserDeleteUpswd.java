package br.com.gda.security.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.userPassword.info.UpswdInfo;
import br.com.gda.security.userPassword.model.decisionTree.RootUpswdDelete;

final class VisiUserDeleteUpswd extends ActionVisitorTemplateAction<UserInfo, UpswdInfo> {
	public VisiUserDeleteUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class, UpswdInfo.class);
	}
	
	
	
	@Override protected List<UpswdInfo> toActionClassHook(List<UserInfo> recordInfos) {
		return UpswdInfo.copyFrom(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		return new RootUpswdDelete(option).toAction();
	}
}
