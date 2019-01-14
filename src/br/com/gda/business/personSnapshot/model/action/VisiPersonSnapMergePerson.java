package br.com.gda.business.personSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.decisionTree.RootPersonSelect;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.info.PersonSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonSnapMergePerson extends ActionVisitorTemplateMerge<PersonSnapInfo, PersonInfo> {
	
	public VisiPersonSnapMergePerson(Connection conn, String schemaName) {
		super(conn, schemaName, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return RootPersonSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PersonSnapInfo>> getMergerClassHook() {
		return PersonSnapMerger.class;
	}
}
