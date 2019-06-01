package br.com.gda.business.orderItem.model.action;

import java.sql.Connection;

import br.com.gda.business.orderItem.info.OrderInfo;
import br.com.gda.business.orderItem.info.OrderMerger;
import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserapSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeUserSnap extends ActionVisitorTemplateMerge_<OrderInfo, UserapInfo> {
	
	public VisiOrderMergeUserSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserapInfo>> getTreeClassHook() {
		return RootUserapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
