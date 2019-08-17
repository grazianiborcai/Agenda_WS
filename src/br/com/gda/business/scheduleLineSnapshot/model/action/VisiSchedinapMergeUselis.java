package br.com.gda.business.scheduleLineSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.model.decisionTree.RootUselisSelect;

final class VisiSchedinapMergeUselis extends ActionVisitorTemplateMergeV2<SchedinapInfo, UselisInfo> {
	
	public VisiSchedinapMergeUselis(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UselisInfo>> getTreeClassHook() {
		return RootUselisSelect.class;
	}
	
	
	
	@Override protected List<SchedinapInfo> mergeHook(List<SchedinapInfo> recordInfos, List<UselisInfo> selectedInfos) {	
		return SchedinapMerger.mergeWithUselis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
