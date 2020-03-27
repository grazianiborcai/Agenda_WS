package br.com.mind5.security.username.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.security.username.info.UsernameInfo;
import br.com.mind5.security.username.info.UsernameMerger;

final class VisiUsernameMergeToSelect extends ActionVisitorTemplateMerge<UsernameInfo, UsernameInfo> {
	
	public VisiUsernameMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UsernameInfo>> getActionClassHook() {
		return StdUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> mergeHook(List<UsernameInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return UsernameMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
