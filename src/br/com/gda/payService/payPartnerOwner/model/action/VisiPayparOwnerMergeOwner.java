package br.com.gda.payService.payPartnerOwner.model.action;

import java.sql.Connection;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.decisionTree.RootOwnerSelect;
import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.model.action.ActionVisitorTemplateMerge;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerInfo;
import br.com.gda.payService.payPartnerOwner.info.PayparOwnerMerger;

final class VisiPayparOwnerMergeOwner extends ActionVisitorTemplateMerge<PayparOwnerInfo, OwnerInfo> {
	
	public VisiPayparOwnerMergeOwner(Connection conn, String schemaName) {
		super(conn, schemaName, OwnerInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<OwnerInfo>> getTreeClassHook() {
		return RootOwnerSelect.class;
	}
	
	
	
	@Override protected Class<? extends InfoWritterFactory_<PayparOwnerInfo>> getMergerClassHook() {
		return PayparOwnerMerger.class;
	}
}
