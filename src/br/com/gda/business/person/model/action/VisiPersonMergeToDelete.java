package br.com.gda.business.person.model.action;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonMergeToDelete extends ActionVisitorTemplateMerge<PersonInfo, PersonInfo> {
	
	public VisiPersonMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonInfo>> getMergerClassHook() {
		return PersonMerger.class;
	}
}
