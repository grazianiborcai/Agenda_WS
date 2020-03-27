package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeToAuth extends ActionVisitorTemplateMerge<UpswdInfo, UpswdInfo> {
	
	public VisiUpswdMergeToAuth(Connection conn, String schemaName) {
		super(conn, schemaName, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<UpswdInfo>> getActionClassHook() {
		return StdUpswdSelect.class;
	}
	
	
	
	@Override protected List<UpswdInfo> mergeHook(List<UpswdInfo> baseInfos, List<UpswdInfo> selectedInfos) {	
		return UpswdMerger.mergeToAuth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
