package br.com.gda.business.store.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStoreMergeCurrency extends ActionVisitorTemplateMerge<StoreInfo, CurrencyInfo> {
	
	public VisiStoreMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<StoreInfo>> getMergerClassHook() {
		return StoreMerger.class;
	}
}
