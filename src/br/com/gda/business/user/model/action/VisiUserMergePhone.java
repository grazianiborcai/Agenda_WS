package br.com.gda.business.user.model.action;

import java.sql.Connection;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.business.phone.model.decisionTree.RootPhoneSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergePhone extends ActionVisitorTemplateMerge<UserInfo, PhoneInfo> {
	
	public VisiUserMergePhone(Connection conn, String schemaName) {
		super(conn, schemaName, PhoneInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PhoneInfo>> getTreeClassHook() {
		return RootPhoneSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserInfo>> getMergerClassHook() {
		return UserMerger.class;
	}
}
