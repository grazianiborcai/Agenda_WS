package br.com.gda.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderSelect;
import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.info.SchedineMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedineMergeOrder extends ActionVisitorTemplateMergeV2<SchedineInfo, OrderInfo> {
	
	public VisiSchedineMergeOrder(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return RootOrderSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<OrderInfo> selectedInfos) {	
		return SchedineMerger.mergeWithOrder(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
