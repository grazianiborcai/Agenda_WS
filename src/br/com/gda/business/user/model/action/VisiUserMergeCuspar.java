package br.com.gda.business.user.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.info.UserMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.payment.customerPartner.info.CusparInfo;
import br.com.gda.payment.customerPartner.model.decisionTree.RootCusparSelect;

final class VisiUserMergeCuspar extends ActionVisitorTemplateMergeV2<UserInfo, CusparInfo> {
	
	public VisiUserMergeCuspar(Connection conn, String schemaName) {
		super(conn, schemaName, CusparInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusparInfo>> getTreeClassHook() {
		return RootCusparSelect.class;
	}
	
	
	
	@Override protected List<UserInfo> mergeHook(List<UserInfo> recordInfos, List<CusparInfo> selectedInfos) {	
		return UserMerger.mergeWithCuspar(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
