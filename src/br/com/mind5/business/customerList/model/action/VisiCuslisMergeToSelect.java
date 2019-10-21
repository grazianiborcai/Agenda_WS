package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.info.CuslisMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiCuslisMergeToSelect extends ActionVisitorTemplateMergeV2<CuslisInfo, CuslisInfo> {
	
	public VisiCuslisMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CuslisInfo>> getActionClassHook() {
		return StdCuslisSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> recordInfos, List<CuslisInfo> selectedInfos) {	
		return CuslisMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
