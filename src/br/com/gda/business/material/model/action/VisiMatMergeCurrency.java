package br.com.gda.business.material.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.CurrencyInfo;
import br.com.gda.business.masterData.model.decisionTree.RootCurrencySelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.info.MatMerger;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.commom.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiMatMergeCurrency extends ActionVisitorTemplateMerge<MatInfo, CurrencyInfo> {
	
	public VisiMatMergeCurrency(Connection conn, String schemaName) {
		super(conn, schemaName, CurrencyInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CurrencyInfo>> getTreeClassHook() {
		return RootCurrencySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<MatInfo>> getMergerClassHook() {
		return MatMerger.class;
	}
}
