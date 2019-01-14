package br.com.gda.payService.payPartnerCountry.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayPartnerSelect;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryInfo;
import br.com.gda.payService.payPartnerCountry.info.PayPartnerCountryMerger;

final class VisiPayPartnerCountryMergePayPartner extends ActionVisitorTemplateMerge<PayPartnerCountryInfo, PayPartnerInfo> {
	
	public VisiPayPartnerCountryMergePayPartner(Connection conn, String schemaName) {
		super(conn, schemaName, PayPartnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayPartnerInfo>> getTreeClassHook() {
		return RootPayPartnerSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory<PayPartnerCountryInfo>> getMergerClassHook() {
		return PayPartnerCountryMerger.class;
	}
}
