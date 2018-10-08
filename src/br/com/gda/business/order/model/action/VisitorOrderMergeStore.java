package br.com.gda.business.order.model.action;

import java.sql.Connection;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.model.decisionTree.RootStoreSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisitorOrderMergeStore extends ActionVisitorTemplateMerge<OrderInfo, StoreInfo> {
	
	public VisitorOrderMergeStore(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StoreInfo>> getTreeClassHook() {
		return RootStoreSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
