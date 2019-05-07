package br.com.gda.business.ownerStore.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.business.ownerStore.info.OwntoreMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOwntoreMergeToSelect extends ActionVisitorTemplateMergeV2<OwntoreInfo, OwntoreInfo> {
	
	public VisiOwntoreMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OwntoreInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OwntoreInfo>> getActionClassHook() {
		return StdOwntoreSelect.class;
	}
	
	
	
	@Override protected List<OwntoreInfo> mergeHook(List<OwntoreInfo> recordInfos, List<OwntoreInfo> selectedInfos) {	
		return OwntoreMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
