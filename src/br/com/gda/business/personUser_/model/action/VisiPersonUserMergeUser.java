package br.com.gda.business.personUser_.model.action;

import java.sql.Connection;

import br.com.gda.business.personUser_.info.PersonUserInfo;
import br.com.gda.business.personUser_.info.PersonUserMerger;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

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
