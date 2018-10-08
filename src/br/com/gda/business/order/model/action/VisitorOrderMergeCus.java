package br.com.gda.business.order.model.action;

import java.sql.Connection;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.model.decisionTree.RootCusSelect;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisitorOrderMergeCus extends ActionVisitorTemplateMerge<OrderInfo, CusInfo> {
	
	public VisitorOrderMergeCus(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusInfo>> getTreeClassHook() {
		return RootCusSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
