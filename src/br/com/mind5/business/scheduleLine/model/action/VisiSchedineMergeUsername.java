package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.model.decisionTree.RootUsernameSelect;

final class VisiSchedineMergeUsername extends ActionVisitorTemplateMergeV2<SchedineInfo, UsernameInfo> {
	
	public VisiSchedineMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return SchedineMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
