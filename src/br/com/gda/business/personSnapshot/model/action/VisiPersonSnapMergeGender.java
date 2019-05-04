package br.com.gda.business.personSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.masterData.model.decisionTree.RootGenderSelect;
import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.info.PersonSnapMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonSnapMergeGender extends ActionVisitorTemplateMerge_<PersonSnapInfo, GenderInfo> {
	
	public VisiPersonSnapMergeGender(Connection conn, String schemaName) {
		super(conn, schemaName, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return RootGenderSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonSnapInfo>> getMergerClassHook() {
		return PersonSnapMerger.class;
	}
}
