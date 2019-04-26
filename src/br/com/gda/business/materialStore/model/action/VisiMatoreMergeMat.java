package br.com.gda.business.materialStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.decisionTree.RootMatSelect;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.info.MatoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatoreMergeMat extends ActionVisitorTemplateMerge<MatoreInfo, MatInfo> {
	
	public VisiMatoreMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<MatoreInfo> recordInfos) {
		return MatInfo.copyFrom(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<MatoreInfo>> getMergerClassHook() {
		return MatoreMerger.class;
	}
}
