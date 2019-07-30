package br.com.gda.payment.payOrderStatus.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.order.info.OrderCopier;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.model.decisionTree.RootOrderUpdate;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.payOrderStatus.info.PaytusInfo;

final class VisiPaytusOrderUpdate extends ActionVisitorTemplateMergeV2<PaytusInfo, OrderInfo> {
	
	public VisiPaytusOrderUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, OrderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderInfo>> getTreeClassHook() {
		return RootOrderUpdate.class;
	}
	
	
	
	@Override protected List<OrderInfo> toActionClassHook(List<PaytusInfo> recordInfos) {
		return OrderCopier.copyFromPaytus(recordInfos);
	}
	
	
	
	@Override protected List<PaytusInfo> mergeHook(List<PaytusInfo> recordInfos, List<OrderInfo> selectedInfos) {	
		return recordInfos;
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
