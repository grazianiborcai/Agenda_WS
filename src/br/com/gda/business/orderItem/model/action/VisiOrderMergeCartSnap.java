package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot_.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot_.model.decisionTree.RootCartSnapSelect;
import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderMerger;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeCartSnap extends ActionVisitorTemplateMerge_<OrderInfo, CartSnapInfo> {
	
	public VisiOrderMergeCartSnap(Connection conn, String schemaName) {
		super(conn, schemaName, CartSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CartSnapInfo>> getTreeClassHook() {
		return RootCartSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
