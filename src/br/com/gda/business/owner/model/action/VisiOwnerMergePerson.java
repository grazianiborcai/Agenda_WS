package br.com.gda.business.owner.model.action;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergePerson extends ActionVisitorTemplateMerge<OwnerInfo, PersonInfo> {
	
	public VisiOwnerMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OwnerInfo>> getMergerClassHook() {
		return OwnerMerger.class;
	}
}
