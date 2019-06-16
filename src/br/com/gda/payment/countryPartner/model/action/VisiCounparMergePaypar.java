package br.com.gda.payment.countryPartner.model.action;

import java.sql.Connection;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.business.masterData.model.decisionTree.RootPayparSelect;
import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge_;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.countryPartner.info.CounparInfo;
import br.com.gda.payment.countryPartner.info.CounparMerger;

final class VisiCounparMergePaypar extends ActionVisitorTemplateMerge_<CounparInfo, PayparInfo> {
	
	public VisiCounparMergePaypar(Connection conn, String schemaName) {
		super(conn, schemaName, PayparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PayparInfo>> getTreeClassHook() {
		return RootPayparSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<CounparInfo>> getMergerClassHook() {
		return CounparMerger.class;
	}
}
