package br.com.gda.business.user.model.action;

import java.sql.Connection;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserKeeper;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateKeep;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerKeepOwner extends ActionVisitorTemplateKeep<UserInfo, UserInfo> {

	public VisiOwnerKeepOwner(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		ActionStd<UserInfo> actionSelect = new StdUserEnforceKey(option);
		actionSelect.addPostAction(new LazyUserRootSelect(option.conn, option.schemaName));
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserInfo>> getKeeperClassHook() {
		return UserKeeper.class;
	}
}
