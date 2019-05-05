package br.com.gda.business.customerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.info.CusarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiCusarchMergeToSelect extends ActionVisitorTemplateMergeV2<CusarchInfo, CusarchInfo> {
	
	public VisiCusarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CusarchInfo>> getActionClassHook() {
		return StdCusarchSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return CusarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
