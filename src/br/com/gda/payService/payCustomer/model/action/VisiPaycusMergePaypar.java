package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;

final class VisiPaycusMergePaypar extends ActionVisitorTemplateMerge<PaycusInfo, PayparInfo> {
	
	public VisiPaycusMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PaycusInfo>> getMergerClassHook() {
		return PaycusMerger.class;
	}
}
