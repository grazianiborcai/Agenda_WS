package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.totalAmount.info.TotAmountInfo;
import br.com.gda.business.totalAmount.model.decisionTree.RootTotAmountCompute;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeTotAmount extends ActionVisitorTemplateMerge<CartInfo, TotAmountInfo> {
	
	public VisiCartMergeTotAmount(Connection conn, String schemaName) {
		super(conn, schemaName, TotAmountInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<TotAmountInfo>> getTreeClassHook() {
		return RootTotAmountCompute.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
