package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderMerger;
import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.business.snapshot_.model.decisionTree.RootSnapInsert;
import br.com.gda.info.obsolete.InfoWritterFactory_;
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
