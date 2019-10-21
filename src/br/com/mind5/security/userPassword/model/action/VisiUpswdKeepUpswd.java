package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;

import br.com.mind5.info.obsolete.InfoWritterFactory_;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateKeep;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdKeeper;
import br.com.mind5.security.userPassword.model.decisionTree.RootUpswdSelect;

final class VisiUpswdKeepUpswd extends ActionVisitorTemplateKeep<UpswdInfo, UpswdInfo> {

	public VisiUpswdKeepUpswd(Connection conn, String schemaName) {
		super(conn, schemaName, UpswdInfo.class);
	}
	
	
	
	@Override protected ActionStd<UpswdInfo> getActionHook(DeciTreeOption<UpswdInfo> option) {
		ActionStd<UpswdInfo> actionSelect = new RootUpswdSelect(option).toAction();
		return actionSelect;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UpswdInfo>> getKeeperClassHook() {
		return UpswdKeeper.class;
	}
}
