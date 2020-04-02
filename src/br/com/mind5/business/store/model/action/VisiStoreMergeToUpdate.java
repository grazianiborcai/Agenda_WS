package br.com.mind5.business.store.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.store.info.StoreCopier;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.info.StoreMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiStoreMergeToUpdate extends ActionVisitorTemplateMerge<StoreInfo, StoreInfo> {
	
	public VisiStoreMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, StoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<StoreInfo>> getActionClassHook() {
		return StdStoreSelect.class;
	}
	
	
	
	@Override protected List<StoreInfo> toActionClassHook(List<StoreInfo> baseInfos) {
		return StoreCopier.copyFromStoreKey(baseInfos);	
	}
	
	
	
	@Override protected List<StoreInfo> mergeHook(List<StoreInfo> baseInfos, List<StoreInfo> selectedInfos) {	
		return StoreMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}	
}
