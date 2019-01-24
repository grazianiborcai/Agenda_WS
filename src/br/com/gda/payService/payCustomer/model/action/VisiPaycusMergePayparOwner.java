package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;

import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.model.decisionTree.RootPayparOwnerSelect;

final class VisiPaycusMergePayparOwner extends ActionVisitorTemplateMerge<PaycusInfo, PayparOwnerInfo> {
	
	public VisiPaycusMergePayparOwner(Connection conn, String schemaName) {
		super(conn, schemaName, PayparOwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparOwnerInfo>> getTreeClassHook() {
		return RootPayparOwnerSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PaycusInfo>> getMergerClassHook() {
		return PaycusMerger.class;
	}
}
