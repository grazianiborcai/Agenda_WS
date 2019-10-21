package br.com.mind5.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserInsertDaemon;

final class VisiOwnerInsertUserDaemon extends ActionVisitorTemplateAction<OwnerInfo, UserInfo> {
	public VisiOwnerInsertUserDaemon(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return UserCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserInsertDaemon(option).toAction();
	}
	
	
	
	@Override protected List<OwnerInfo> toBaseClassHook(List<OwnerInfo> baseInfos, List<UserInfo> results) {
		return baseInfos;
	}
}
