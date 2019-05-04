package br.com.gda.business.order.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.OrderStatusInfo;
import br.com.gda.business.masterData.model.decisionTree.RootOrderStatusSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeOrderStatus extends ActionVisitorTemplateMerge_<OrderInfo, OrderStatusInfo> {
	
	public VisiOrderMergeOrderStatus(Connection conn, String schemaName) {
		super(conn, schemaName, OrderStatusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OrderStatusInfo>> getTreeClassHook() {
		return RootOrderStatusSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
