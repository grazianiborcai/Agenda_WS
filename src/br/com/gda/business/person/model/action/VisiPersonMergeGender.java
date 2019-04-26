package br.com.gda.business.person.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.info.PersonMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonMergeGender extends ActionVisitorTemplateMerge<PersonInfo, GenderInfo> {
	
	public VisiPersonMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return RootGenderSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonInfo>> getMergerClassHook() {
		return PersonMerger.class;
	}
}
