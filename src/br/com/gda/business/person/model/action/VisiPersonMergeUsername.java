package br.com.gda.business.person.model.action;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiPersonMergeUsername extends ActionVisitorTemplateMerge<PersonInfo, UsernameInfo> {
	
	public VisiPersonMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonInfo>> getMergerClassHook() {
		return PersonMerger.class;
	}
}
