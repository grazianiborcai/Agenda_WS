package br.com.gda.business.order.model.action;

import java.sql.Connection;

import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.order.info.OrderMerger;
import br.com.gda.business.userSnapshot.info.UserSnapInfo;
import br.com.gda.business.userSnapshot.model.decisionTree.RootUserSnapSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrderMergeUserSnap extends ActionVisitorTemplateMerge_<OrderInfo, UserSnapInfo> {
	
	public VisiOrderMergeUserSnap(Connection conn, String schemaName) {
		super(conn, schemaName, UserSnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserSnapInfo>> getTreeClassHook() {
		return RootUserSnapSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<OrderInfo>> getMergerClassHook() {
		return OrderMerger.class;
	}
}
