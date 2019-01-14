package br.com.gda.payService.payPartnerStore.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayPartnerSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreMerger;

final class VisiPayPartnerStoreMergePayPartner extends ActionVisitorTemplateMerge<PayPartnerStoreInfo, PayPartnerInfo> {
	
	public VisiPayPartnerStoreMergePayPartner(Connection conn, String schemaName) {
		super(conn, schemaName, PayPartnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayPartnerInfo>> getTreeClassHook() {
		return RootPayPartnerSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayPartnerStoreInfo>> getMergerClassHook() {
		return PayPartnerStoreMerger.class;
	}
}
