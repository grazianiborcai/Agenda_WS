package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderItem.info.OrderemInfo;
import br.com.gda.business.orderItem.info.OrderemMerger;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderemMergeEmplis extends ActionVisitorTemplateMergeV2<OrderemInfo, EmplisInfo> {
	
	public VisiOrderemMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}
	
	
	
	@Override protected List<OrderemInfo> mergeHook(List<OrderemInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return OrderemMerger.mergeWithEmplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
