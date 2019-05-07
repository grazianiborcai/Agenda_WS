package br.com.gda.business.materialStock.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.info.MatockMerger;
import br.com.gda.business.materialStock.model.decisionTree.RootMatockSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatockMergeToUpdate extends ActionVisitorTemplateMergeV2<MatockInfo, MatockInfo> {
	
	public VisiMatockMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, MatockInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatockInfo>> getTreeClassHook() {
		return RootMatockSelect.class;
	}
	
	
	
	@Override protected List<MatockInfo> mergeHook(List<MatockInfo> recordInfos, List<MatockInfo> selectedInfos) {	
		return MatockMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
