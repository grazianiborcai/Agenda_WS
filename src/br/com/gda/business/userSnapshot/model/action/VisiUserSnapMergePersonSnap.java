package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.decisionTree.RootPersonSnapSelect;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergePersonSnap extends ActionVisitorTemplateMerge_<UserSnapInfo, PersonSnapInfo> {
	
	public VisiUserSnapMergePersonSnap(Connection conn, String schemaName) {
		super(conn, schemaName, PersonSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonSnapInfo>> getTreeClassHook() {
		return RootPersonSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
