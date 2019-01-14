package br.com.gda.business.cart.model.action;

import java.sql.Connection;

import br.com.gda.business.cart.info.CartInfo;
import br.com.gda.business.cart.info.CartMerger;
import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.business.feeDefault.model.decisionTree.RootFeeDefaultSelectService;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartMergeFeeDefault extends ActionVisitorTemplateMerge<CartInfo, FeeDefaultInfo> {
	
	public VisiCartMergeFeeDefault(Connection conn, String schemaName) {
		super(conn, schemaName, FeeDefaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FeeDefaultInfo>> getTreeClassHook() {
		return RootFeeDefaultSelectService.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartInfo>> getMergerClassHook() {
		return CartMerger.class;
	}
}
