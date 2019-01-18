package br.com.gda.payService.payPartnerOwner.model.action;

import java.sql.Connection;

import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;
import br.com.gda.payService.payPartnerCountry.model.decisionTree.RootPayparCountrySelect;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerMerger;

final class VisiPayparOwnerMergePayparCountry extends ActionVisitorTemplateMerge<PayparOwnerInfo, PayparCountryInfo> {
	
	public VisiPayparOwnerMergePayparCountry(Connection conn, String schemaName) {
		super(conn, schemaName, PayparCountryInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparCountryInfo>> getTreeClassHook() {
		return RootPayparCountrySelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayparOwnerInfo>> getMergerClassHook() {
		return PayparOwnerMerger.class;
	}
}
