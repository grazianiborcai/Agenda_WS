package br.com.gda.business.materialSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.business.masterData.model.decisionTree.RootMatTypeSelect;
import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.info.MatSnapMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatSnapMergeMatType extends ActionVisitorTemplateMerge<MatSnapInfo, MatTypeInfo> {
	
	public VisiMatSnapMergeMatType(Connection conn, String schemaName) {
		super(conn, schemaName, MatTypeInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatTypeInfo>> getTreeClassHook() {
		return RootMatTypeSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatSnapInfo>> getMergerClassHook() {
		return MatSnapMerger.class;
	}
}
