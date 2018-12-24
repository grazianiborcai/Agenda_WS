package br.com.gda.business.order.model.action;

import java.sql.Connection;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.materialSnapshot.model.decisionTree.RootMatSnapInsert;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeMatSnap extends ActionVisitorTemplateMerge<OrderInfo, MatSnapInfo> {
	
	public VisiOrderMergeMatSnap(Connection conn, String schemaName) {
		super(conn, schemaName, MatSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<MatSnapInfo>> getTreeClassHook() {
		return RootMatSnapInsert.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
