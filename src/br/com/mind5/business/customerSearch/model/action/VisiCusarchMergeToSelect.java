package br.com.mind5.business.customerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.info.CusarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiCusarchMergeToSelect extends ActionVisitorTemplateMergeV1<CusarchInfo, CusarchInfo> {
	
	public VisiCusarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CusarchInfo>> getActionClassHook() {
		return StdCusarchSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return CusarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
