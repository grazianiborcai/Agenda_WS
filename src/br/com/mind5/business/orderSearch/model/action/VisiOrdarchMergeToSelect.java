package br.com.mind5.business.orderSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderSearch.info.OrdarchInfo;
import br.com.mind5.business.orderSearch.info.OrdarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrdarchMergeToSelect extends ActionVisitorTemplateMerge<OrdarchInfo, OrdarchInfo> {
	
	public VisiOrdarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdarchInfo>> getActionClassHook() {
		return StdOrdarchSelect.class;
	}
	
	
	
	@Override protected List<OrdarchInfo> mergeHook(List<OrdarchInfo> baseInfos, List<OrdarchInfo> selectedInfos) {	
		return OrdarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
