package br.com.mind5.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.info.StorapMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStorapMergeToSelect extends ActionVisitorTemplateMerge<StorapInfo, StorapInfo> {
	
	public VisiStorapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorapInfo>> getActionClassHook() {
		return StdStorapSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<StorapInfo> selectedInfos) {	
		return StorapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}	
}
