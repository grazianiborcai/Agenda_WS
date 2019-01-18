package br.com.gda.payService.payPartnerStore.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;
import br.com.gda.payService.payPartnerStore.info.PayparStoreMerger;

final class VisiPayparStoreMergePaypar extends ActionVisitorTemplateMerge<PayparStoreInfo, PayparInfo> {
	
	public VisiPayparStoreMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayparStoreInfo>> getMergerClassHook() {
		return PayparStoreMerger.class;
	}
}
