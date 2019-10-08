package br.com.gda.business.storeLeaveDate.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolateInfo;
import br.com.gda.business.storeLeaveDate.info.StolateMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiStolateMergeUsername extends ActionVisitorTemplateMergeV2<StolateInfo, UsernameInfo> {
	
	public VisiStolateMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	protected List<UsernameInfo> toActionClassHook(List<StolateInfo> recordInfos) {
		return UsernameCopier.copyFromStolate(recordInfos);	
	}
	
	
	
	@Override protected List<StolateInfo> mergeHook(List<StolateInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return StolateMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
