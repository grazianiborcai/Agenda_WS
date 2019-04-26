package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapMerger;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.decisionTree.RootSnapInsert;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatSnapMergeSnap extends ActionVisitorTemplateMerge<MatSnapInfo, SnapInfo> {
	
	public VisiMatSnapMergeSnap(Connection conn, String schemaName) {
		super(conn, schemaName, SnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SnapInfo>> getTreeClassHook() {
		return RootSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatSnapInfo>> getMergerClassHook() {
		return MatSnapMerger.class;
	}
}
