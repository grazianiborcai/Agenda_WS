package br.com.gda.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.customer.info.CusMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiCusMergeToSelect extends ActionVisitorTemplateMergeV2<CusInfo, CusInfo> {
	
	public VisiCusMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusInfo>> getActionClassHook() {
		return StdCusSelect.class;
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusInfo> selectedInfos) {	
		return CusMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
