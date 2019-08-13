package br.com.gda.business.storeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeSnapshot.info.StorapInfo;
import br.com.gda.business.storeSnapshot.info.StorapMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiStorapMergeToSelect extends ActionVisitorTemplateMergeV2<StorapInfo, StorapInfo> {
	
	public VisiStorapMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, StorapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StorapInfo>> getActionClassHook() {
		return StdStoreSelect.class;
	}
	
	
	
	@Override protected List<StorapInfo> mergeHook(List<StorapInfo> recordInfos, List<StorapInfo> selectedInfos) {	
		return StorapMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
