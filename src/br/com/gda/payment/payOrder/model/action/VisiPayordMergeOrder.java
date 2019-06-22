package br.com.gda.payment.payOrder.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrder.info.PayordInfo;
import br.com.gda.payment.payOrder.info.PayordMerger;

final class VisiPayordMergeOrder extends ActionVisitorTemplateMergeV2<PayordInfo, OrderInfo> {
	
	public VisiPayordMergeOrder(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return RootOrderSelect.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PayordInfo> recordInfos) {
		return OrderCopier.copyFromPayord(recordInfos);	
	}
	
	
	
	@Override protected List<PayordInfo> mergeHook(List<PayordInfo> recordInfos, List<OrderInfo> selectedInfos) {	
		return PayordMerger.mergeWithOrder(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
