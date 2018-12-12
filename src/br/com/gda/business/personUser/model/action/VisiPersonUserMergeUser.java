package br.com.gda.business.personUser.model.action;

import java.sql.Connection;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.business.personUser.info.PersonUserMerger;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonUserMergeUser extends ActionVisitorTemplateMerge<PersonUserInfo, UserInfo> {
	
	public VisiPersonUserMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PersonUserInfo>> getMergerClassHook() {
		return PersonUserMerger.class;
	}
}
