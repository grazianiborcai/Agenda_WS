package br.com.mind5.security.userSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.info.UserarchMerger;

final class VisiUserarchMergeToSelect extends ActionVisitorTemplateMergeV2<UserarchInfo, UserarchInfo> {
	
	public VisiUserarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserarchInfo>> getActionClassHook() {
		return StdUserarchSelect.class;
	}
	
	
	
	@Override protected List<UserarchInfo> mergeHook(List<UserarchInfo> recordInfos, List<UserarchInfo> selectedInfos) {	
		return UserarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
