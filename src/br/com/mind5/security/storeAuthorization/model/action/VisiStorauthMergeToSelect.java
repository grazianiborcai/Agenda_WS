package br.com.mind5.security.storeAuthorization.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.security.storeAuthorization.info.StorauthInfo;
import br.com.mind5.security.storeAuthorization.info.StorauthMerger;

final class VisiStorauthMergeToSelect extends ActionVisitorTemplateMergeV2<StorauthInfo, StorauthInfo> {
	
	public VisiStorauthMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StorauthInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorauthInfo>> getActionClassHook() {
		return StdStorauthSelect.class;
	}
	
	
	
	@Override protected List<StorauthInfo> mergeHook(List<StorauthInfo> recordInfos, List<StorauthInfo> selectedInfos) {	
		return StorauthMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
