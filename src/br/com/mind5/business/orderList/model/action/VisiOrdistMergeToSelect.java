package br.com.mind5.business.orderList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.orderList.info.OrdistMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrdistMergeToSelect extends ActionVisitorTemplateMerge<OrdistInfo, OrdistInfo> {
	
	public VisiOrdistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OrdistInfo>> getActionClassHook() {
		return StdOrdistSelect.class;
	}
	
	
	
	@Override protected List<OrdistInfo> mergeHook(List<OrdistInfo> baseInfos, List<OrdistInfo> selectedInfos) {	
		return OrdistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
