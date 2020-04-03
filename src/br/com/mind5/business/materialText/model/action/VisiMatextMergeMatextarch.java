package br.com.mind5.business.materialText.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialText.info.MatextMerger;
import br.com.mind5.business.materialTextSearch.info.MatextarchCopier;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.business.materialTextSearch.model.decisionTree.RootMatextarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiMatextMergeMatextarch extends ActionVisitorTemplateMergeV1<MatextInfo, MatextarchInfo> {
	
	public VisiMatextMergeMatextarch(Connection conn, String schemaName) {
		super(conn, schemaName, MatextarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatextarchInfo>> getTreeClassHook() {
		return RootMatextarchSelect.class;
	}
	
	
	
	@Override protected List<MatextarchInfo> toActionClassHook(List<MatextInfo> recordInfos) {
		return MatextarchCopier.copyFromMatext(recordInfos);	
	}
	
	
	
	@Override protected List<MatextInfo> mergeHook(List<MatextInfo> recordInfos, List<MatextarchInfo> selectedInfos) {	
		return MatextMerger.mergeWithMatextarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
