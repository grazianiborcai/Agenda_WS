package br.com.gda.business.store.model.action;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStoreMergePerson extends ActionVisitorTemplateMerge<StoreInfo, PersonInfo> {
	
	public VisiStoreMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StoreInfo>> getMergerClassHook() {
		return StoreMerger.class;
	}
}
