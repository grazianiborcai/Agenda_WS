package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserRootDelete;
import br.com.gda.business.user.model.action.StdUserEnforceKey;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiOwnerDeleteUser extends ActionVisitorTemplateAction<OwnerInfo, UserInfo> {
	public VisiOwnerDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return UserCopier.copyFromOwner(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		ActionStd<UserInfo> enforceUserKey = new StdUserEnforceKey(option);
		ActionLazy<UserInfo> deleteUser = new LazyUserRootDelete(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(deleteUser);		
		return enforceUserKey;
	}
}
