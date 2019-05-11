package br.com.gda.business.userSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.decisionTree.RootSnapInsert;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.info.UserSnapMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiUserSnapMergeSnap extends ActionVisitorTemplateMerge_<UserSnapInfo, SnapInfo> {
	
	public VisiUserSnapMergeSnap(Connection conn, String schemaName) {
		super(conn, schemaName, SnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SnapInfo>> getTreeClassHook() {
		return RootSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<UserSnapInfo>> getMergerClassHook() {
		return UserSnapMerger.class;
	}
}
