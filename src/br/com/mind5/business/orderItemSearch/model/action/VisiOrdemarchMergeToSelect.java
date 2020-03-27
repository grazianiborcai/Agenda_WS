package br.com.mind5.business.orderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiOrdemarchMergeToSelect extends ActionVisitorTemplateMerge<OrdemarchInfo, OrdemarchInfo> {
	
	public VisiOrdemarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<OrdemarchInfo>> getActionClassHook() {
		return StdOrdemarchSelect.class;
	}
	
	
	
	@Override protected List<OrdemarchInfo> mergeHook(List<OrdemarchInfo> recordInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrdemarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
