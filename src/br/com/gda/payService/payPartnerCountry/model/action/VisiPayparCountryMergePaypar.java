package br.com.gda.payService.payPartnerCountry.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryInfo;
import br.com.gda.payService.payPartnerCountry.info.PayparCountryMerger;

final class VisiPayparCountryMergePaypar extends ActionVisitorTemplateMerge<PayparCountryInfo, PayparInfo> {
	
	public VisiPayparCountryMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayparCountryInfo>> getMergerClassHook() {
		return PayparCountryMerger.class;
	}
}
