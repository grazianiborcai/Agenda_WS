package br.com.mind5.payment.storePartner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.payment.storePartner.info.StoparInfo;
import br.com.mind5.payment.storePartner.info.StoparMerger;
import br.com.mind5.security.username.info.UsernameCopier;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStoparMergeUsername extends ActionVisitorTemplateMergeV2<StoparInfo, UsernameInfo> {
	
	public VisiStoparMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<StoparInfo> recordInfos) {
		return UsernameCopier.copyFromStopar(recordInfos);	
	}
	
	
	
	@Override protected List<StoparInfo> mergeHook(List<StoparInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return StoparMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
