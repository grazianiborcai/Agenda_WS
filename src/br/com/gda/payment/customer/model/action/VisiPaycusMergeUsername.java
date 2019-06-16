package br.com.gda.payment.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.payment.customer.info.PaycusMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiPaycusMergeUsername extends ActionVisitorTemplateMergeV2<PaycusInfo, UsernameInfo> {
	
	public VisiPaycusMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<PaycusInfo> mergeHook(List<PaycusInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return PaycusMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
