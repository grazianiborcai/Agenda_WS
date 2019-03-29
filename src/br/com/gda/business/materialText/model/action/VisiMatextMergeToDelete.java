package br.com.gda.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialText.info.MatextCopier;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.info.MatextMerger;
import br.com.gda.business.materialText.model.decisionTree.RootMatextSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatextMergeToDelete extends ActionVisitorTemplateMerge<MatextInfo, MatextInfo> {
	
	public VisiMatextMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, MatextInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextInfo>> getTreeClassHook() {
		return RootMatextSelect.class;
	}
	
	
	
	@Override 	protected List<MatextInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return MatextCopier.copyToDelete(recordInfos);	
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatextInfo>> getMergerClassHook() {
		return MatextMerger.class;
	}
}
