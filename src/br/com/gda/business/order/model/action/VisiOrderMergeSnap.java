package br.com.gda.business.order.model.action;

import java.sql.Connection;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.decisionTree.RootSnapInsert;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeSnap extends ActionVisitorTemplateMerge_<OrderInfo, SnapInfo> {
	
	public VisiOrderMergeSnap(Connection conn, String schemaName) {
		super(conn, schemaName, SnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<SnapInfo>> getTreeClassHook() {
		return RootSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
