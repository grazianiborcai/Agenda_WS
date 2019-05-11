package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.totalAmount.model.decisionTree.RootTotAmountCompute;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeTotAmount extends ActionVisitorTemplateMerge_<CartInfo, TotAmountInfo> {
	
	public VisiCartMergeTotAmount(Connection conn, String schemaName) {
		super(conn, schemaName, TotAmountInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TotAmountInfo>> getTreeClassHook() {
		return RootTotAmountCompute.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
