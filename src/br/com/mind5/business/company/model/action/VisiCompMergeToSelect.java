package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCompMergeToSelect extends ActionVisitorTemplateMerge<CompInfo, CompInfo> {
	
	public VisiCompMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<CompInfo>> getActionClassHook() {
		return StdCompSelect.class;
	}
	
	
	
	@Override protected List<CompInfo> mergeHook(List<CompInfo> recordInfos, List<CompInfo> selectedInfos) {	
		return CompMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
