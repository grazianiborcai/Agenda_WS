package br.com.gda.security.userList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.userList.info.UselisMerger;

final class VisiUselisMergePersolis extends ActionVisitorTemplateMergeV2<UselisInfo, PersolisInfo> {
	
	public VisiUselisMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return UselisMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
