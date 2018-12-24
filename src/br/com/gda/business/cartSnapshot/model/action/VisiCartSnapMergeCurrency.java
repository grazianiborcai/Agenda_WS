package br.com.gda.business.cartSnapshot.model.action;

import java.sql.Connection;

import br.com.gda.business.cartSnapshot.info.CartSnapInfo;
import br.com.gda.business.cartSnapshot.info.CartSnapMerger;
import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCartSnapMergeCurrency extends ActionVisitorTemplateMerge<CartSnapInfo, CurrencyInfo> {
	
	public VisiCartSnapMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<CartSnapInfo>> getMergerClassHook() {
		return CartSnapMerger.class;
	}
}
