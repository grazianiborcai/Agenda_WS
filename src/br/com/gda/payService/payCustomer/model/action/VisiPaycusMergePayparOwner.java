package br.com.gda.payService.payCustomer.model.action;

import java.sql.Connection;

import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payCustomer.info.PaycusInfo;
import br.com.gda.payService.payCustomer.info.PaycusMerger;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;
import br.com.gda.payment.ownerPartner.model.decisionTree.RootOwnparSelect;

final class VisiPaycusMergePayparOwner extends ActionVisitorTemplateMerge_<PaycusInfo, OwnparInfo> {
	
	public VisiPaycusMergePayparOwner(Connection conn, String schemaName) {
		super(conn, schemaName, OwnparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnparInfo>> getTreeClassHook() {
		return RootOwnparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PaycusInfo>> getMergerClassHook() {
		return PaycusMerger.class;
	}
}
