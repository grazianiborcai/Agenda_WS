package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.decisionTree.RootMatockSelect;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatoreMergeMatock extends ActionVisitorTemplateMerge<MatoreInfo, MatockInfo> {
	
	public VisiMatoreMergeMatock(Connection conn, String schemaName) {
		super(conn, schemaName, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return RootMatockSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatoreInfo>> getMergerClassHook() {
		return MatoreMerger.class;
	}
}
