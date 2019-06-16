package br.com.gda.payment.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.info.PaycusMerger;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.business.user.model.decisionTree.RootUserSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPaycusMergeUser extends ActionVisitorTemplateMergeV2<PaycusInfo, UserInfo> {
	
	public VisiPaycusMergeUser(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelect.class;
	}
	
	
	
	@Override protected List<PaycusInfo> mergeHook(List<PaycusInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return PaycusMerger.mergeWithUser(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
