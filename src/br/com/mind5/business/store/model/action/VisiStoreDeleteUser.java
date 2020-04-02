package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserDelete;

final class VisiStoreDeleteUser extends ActionVisitorTemplateAction<StoreInfo, UserInfo> {
	public VisiStoreDeleteUser(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class, UserInfo.class);
	}
	
	
	
	@Override protected List<UserInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return UserCopier.copyFromStoreKey(recordInfos);
	}
	
	
	
	@Override protected ActionStdV1<UserInfo> getActionHook(DeciTreeOption<UserInfo> option) {
		return new RootUserDelete(option).toAction();
	}
	
	
	
	@Override protected List<StoreInfo> toBaseClassHook(List<StoreInfo> baseInfos, List<UserInfo> results) {
		return baseInfos;
	}
}
