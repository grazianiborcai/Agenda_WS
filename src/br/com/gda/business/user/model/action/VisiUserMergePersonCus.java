package br.com.gda.business.user.model.action;

import java.sql.Connection;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.business.personCustomer.model.decisionTree.RootPersonCusSelect;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserMergePersonCus extends ActionVisitorTemplateMerge<UserInfo, PersonCusInfo> {
	
	public VisiUserMergePersonCus(Connection conn, String schemaName) {
		super(conn, schemaName, PersonCusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonCusInfo>> getTreeClassHook() {
		return RootPersonCusSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserInfo>> getMergerClassHook() {
		return UserMerger.class;
	}
}
