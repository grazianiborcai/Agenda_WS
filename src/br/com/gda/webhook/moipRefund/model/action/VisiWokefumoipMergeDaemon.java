package br.com.gda.webhook.moipRefund.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.decisionTree.RootUserSelectDaemon;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;
import br.com.gda.webhook.moipRefund.info.WokefumoipMerger;

final class VisiWokefumoipMergeDaemon extends ActionVisitorTemplateMergeV2<WokefumoipInfo, UserInfo> {
	
	public VisiWokefumoipMergeDaemon(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelectDaemon.class;
	}
	
	
	
	@Override protected List<WokefumoipInfo> mergeHook(List<WokefumoipInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return WokefumoipMerger.mergeWithDaemon(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
