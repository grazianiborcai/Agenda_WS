package br.com.mind5.business.orderItemSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiOrdemarchMergeToSelect extends ActionVisitorTemplateMergeV1<OrdemarchInfo, OrdemarchInfo> {
	
	public VisiOrdemarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, OrdemarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<OrdemarchInfo>> getActionClassHook() {
		return StdOrdemarchDaoSelect.class;
	}
	
	
	
	@Override protected List<OrdemarchInfo> mergeHook(List<OrdemarchInfo> baseInfos, List<OrdemarchInfo> selectedInfos) {	
		return OrdemarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
