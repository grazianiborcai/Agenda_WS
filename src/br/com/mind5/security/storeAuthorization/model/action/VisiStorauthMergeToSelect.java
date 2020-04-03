package br.com.mind5.security.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.info.StorauthMerger;

final class VisiStorauthMergeToSelect extends ActionVisitorTemplateMergeV1<StorauthInfo, StorauthInfo> {
	
	public VisiStorauthMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StorauthInfo>> getActionClassHook() {
		return StdStorauthSelect.class;
	}
	
	
	
	@Override protected List<StorauthInfo> mergeHook(List<StorauthInfo> recordInfos, List<StorauthInfo> selectedInfos) {	
		return StorauthMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
