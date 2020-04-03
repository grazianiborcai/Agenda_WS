package br.com.mind5.security.userPassword.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.security.userPassword.info.UpswdInfo;
import br.com.mind5.security.userPassword.info.UpswdMerger;

final class VisiUpswdMergeToAuth extends ActionVisitorTemplateMergeV1<UpswdInfo, UpswdInfo> {
	
	public VisiUpswdMergeToAuth(Connection conn, String schemaName) {
		super(conn, schemaName, UpswdInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<UpswdInfo>> getActionClassHook() {
		return StdUpswdSelect.class;
	}
	
	
	
	@Override protected List<UpswdInfo> mergeHook(List<UpswdInfo> baseInfos, List<UpswdInfo> selectedInfos) {	
		return UpswdMerger.mergeToAuth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
