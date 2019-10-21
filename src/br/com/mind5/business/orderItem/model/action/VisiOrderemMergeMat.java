package br.com.mind5.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.material.info.MatCopier;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.decisionTree.RootMatSelect;
import br.com.mind5.business.orderItem.info.OrderemInfo;
import br.com.mind5.business.orderItem.info.OrderemMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiOrderemMergeMat extends ActionVisitorTemplateMergeV2<OrderemInfo, MatInfo> {
	
	public VisiOrderemMergeMat(Connection conn, String schemaName) {
		super(conn, schemaName, MatInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatInfo>> getTreeClassHook() {
		return RootMatSelect.class;
	}
	
	
	
	@Override protected List<MatInfo> toActionClassHook(List<OrderemInfo> recordInfos) {
		return MatCopier.copyFromOrderem(recordInfos);	
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> recordInfos, List<MatInfo> selectedInfos) {	
		return OrderemMerger.mergeWithMat(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
