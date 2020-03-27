package br.com.mind5.business.companySearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.business.companySearch.info.ComparchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiComparchMergeToSelect extends ActionVisitorTemplateMerge<ComparchInfo, ComparchInfo> {
	
	public VisiComparchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, ComparchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<ComparchInfo>> getActionClassHook() {
		return StdComparchSelect.class;
	}
	
	
	
	@Override protected List<ComparchInfo> mergeHook(List<ComparchInfo> recordInfos, List<ComparchInfo> selectedInfos) {	
		return ComparchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
