package br.com.mind5.security.userList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.userList.info.UselisMerger;

final class VisiUselisMergeToSelect extends ActionVisitorTemplateMergeV2<UselisInfo, UselisInfo> {
	
	public VisiUselisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UselisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UselisInfo>> getActionClassHook() {
		return StdUselisSelect.class;
	}
	
	
	
	@Override protected List<UselisInfo> mergeHook(List<UselisInfo> baseInfos, List<UselisInfo> selectedInfos) {	
		return UselisMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
