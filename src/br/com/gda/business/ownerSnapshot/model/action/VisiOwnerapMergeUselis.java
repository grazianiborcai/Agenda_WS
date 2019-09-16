package br.com.gda.business.ownerSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.business.ownerSnapshot.info.OwnerapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.model.decisionTree.RootUselisSelect;

final class VisiOwnerapMergeUselis extends ActionVisitorTemplateMergeV2<OwnerapInfo, UselisInfo> {
	
	public VisiOwnerapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	//TODO: incluir Copier
	
	
	@Override protected List<OwnerapInfo> mergeHook(List<OwnerapInfo> recordInfos, List<UselisInfo> selectedInfos) {	
		return OwnerapMerger.mergeWithUselis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
