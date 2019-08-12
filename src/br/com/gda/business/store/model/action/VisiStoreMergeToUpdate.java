package br.com.gda.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.store.info.StoreCopier;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.store.info.StoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiStoreMergeToUpdate extends ActionVisitorTemplateMergeV2<StoreInfo, StoreInfo> {
	
	public VisiStoreMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<StoreInfo>> getActionClassHook() {
		return StdStoreSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<StoreInfo> recordInfos) {
		return StoreCopier.copyFromStoreKey(recordInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> recordInfos, List<StoreInfo> selectedInfos) {	
		return StoreMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}	
}
