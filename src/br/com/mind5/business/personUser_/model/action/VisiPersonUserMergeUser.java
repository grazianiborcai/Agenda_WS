package br.com.mind5.business.personUser_.model.action;

import java.sql.Connection;

import br.com.mind5.business.personUser_.info.PersonUserInfo;
import br.com.mind5.business.personUser_.info.PersonUserMerger;
import br.com.mind5.info.obsolete.InfoWritterFactory_;
import br.com.mind5.model.action.obsolete.ActionVisitorTemplateMerge_;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.decisionTree.RootUserSelect;

final class VisiPersonUserMergeUser extends ActionVisitorTemplateMerge_<PersonUserInfo, UserInfo> {
	
	public VisiPersonUserMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonUserInfo>> getMergerClassHook() {
		return PersonUserMerger.class;
	}
}
