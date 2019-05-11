package br.com.gda.business.personSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.info.PersonSnapMerger;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.decisionTree.RootSnapInsert;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPersonSnapMergeSnap extends ActionVisitorTemplateMerge_<PersonSnapInfo, SnapInfo> {
	
	public VisiPersonSnapMergeSnap(Connection conn, String schemaName) {
		super(conn, schemaName, SnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SnapInfo>> getTreeClassHook() {
		return RootSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PersonSnapInfo>> getMergerClassHook() {
		return PersonSnapMerger.class;
	}
}
