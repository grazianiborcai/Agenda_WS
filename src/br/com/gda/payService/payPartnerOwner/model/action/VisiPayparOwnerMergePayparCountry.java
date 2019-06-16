package br.com.gda.payService.payPartnerOwner.model.action;

import java.sql.Connection;

import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerMerger;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.model.decisionTree.RootCounparSelect;

final class VisiPayparOwnerMergePayparCountry extends ActionVisitorTemplateMerge_<PayparOwnerInfo, CounparInfo> {
	
	public VisiPayparOwnerMergePayparCountry(Connection conn, String schemaName) {
		super(conn, schemaName, CounparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CounparInfo>> getTreeClassHook() {
		return RootCounparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PayparOwnerInfo>> getMergerClassHook() {
		return PayparOwnerMerger.class;
	}
}
