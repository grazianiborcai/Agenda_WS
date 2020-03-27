package br.com.mind5.security.userSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.info.UserarchMerger;

final class VisiUserarchMergeToSelect extends ActionVisitorTemplateMerge<UserarchInfo, UserarchInfo> {
	
	public VisiUserarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UserarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UserarchInfo>> getActionClassHook() {
		return StdUserarchSelect.class;
	}
	
	
	
	@Override protected List<UserarchInfo> mergeHook(List<UserarchInfo> baseInfos, List<UserarchInfo> selectedInfos) {	
		return UserarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
