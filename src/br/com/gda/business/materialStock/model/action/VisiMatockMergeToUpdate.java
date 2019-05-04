package br.com.gda.business.materialStock.model.action;

import java.sql.Connection;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockMerger;
import br.com.gda.business.materialStock.model.decisionTree.RootMatockSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatockMergeToUpdate extends ActionVisitorTemplateMerge_<MatockInfo, MatockInfo> {
	
	public VisiMatockMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return RootMatockSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatockInfo>> getMergerClassHook() {
		return MatockMerger.class;
	}
}
