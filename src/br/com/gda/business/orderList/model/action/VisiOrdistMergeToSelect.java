package br.com.gda.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.orderList.info.OrdistMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrdistMergeToSelect extends ActionVisitorTemplateMergeV2<OrdistInfo, OrdistInfo> {
	
	public VisiOrdistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdistInfo>> getActionClassHook() {
		return StdOrdistSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> recordInfos, List<OrdistInfo> selectedInfos) {	
		return OrdistMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
