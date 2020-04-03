package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiStorapMergeToSelect extends ActionVisitorTemplateMergeV1<StorapInfo, StorapInfo> {
	
	public VisiStorapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StorapInfo>> getActionClassHook() {
		return StdStorapSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<StorapInfo> selectedInfos) {	
		return StorapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}	
}
