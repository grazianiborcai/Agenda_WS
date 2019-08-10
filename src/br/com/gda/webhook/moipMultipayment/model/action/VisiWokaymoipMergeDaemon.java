package br.com.gda.webhook.moipMultipayment.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.user.info.UserInfo;
import br.com.gda.security.user.model.decisionTree.RootUserSelectDaemon;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipMerger;

final class VisiWokaymoipMergeDaemon extends ActionVisitorTemplateMergeV2<WokaymoipInfo, UserInfo> {
	
	public VisiWokaymoipMergeDaemon(Connection conn, String schemaName) {
		super(conn, schemaName, UserInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UserInfo>> getTreeClassHook() {
		return RootUserSelectDaemon.class;
	}
	
	
	
	@Override protected List<WokaymoipInfo> mergeHook(List<WokaymoipInfo> recordInfos, List<UserInfo> selectedInfos) {	
		return WokaymoipMerger.mergeWithDaemon(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
