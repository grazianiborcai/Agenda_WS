package br.com.gda.business.orderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.orderSearch.info.OrdarchInfo;
import br.com.gda.business.orderSearch.info.OrdarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiOrdarchMergeToSelect extends ActionVisitorTemplateMergeV2<OrdarchInfo, OrdarchInfo> {
	
	public VisiOrdarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdarchInfo>> getActionClassHook() {
		return StdOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrdarchInfo> mergeHook(List<OrdarchInfo> recordInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
