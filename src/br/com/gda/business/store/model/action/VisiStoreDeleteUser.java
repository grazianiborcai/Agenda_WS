package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.user.info.UserCopier;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.action.LazyUserRootDelete;
import br.com.gda.business.user.model.action.StdUserEnforceKey;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateAction;
import br.com.gda.model.decisionTree.DeciTreeOption;

final class VisiStoreDeleteUser extends ActionVisitorTemplateAction<StoreInfo, UserInfo> {
	public VisiStoreDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return UserCopier.copyFromStore(recordInfos);
	}
	
	
	
	@Override protected ActionStd<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		ActionStd<UserInfo> enforceUserKey = new StdUserEnforceKey(option);
		ActionLazy<UserInfo> deleteUser = new LazyUserRootDelete(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(deleteUser);		
		return enforceUserKey;
	}
}
