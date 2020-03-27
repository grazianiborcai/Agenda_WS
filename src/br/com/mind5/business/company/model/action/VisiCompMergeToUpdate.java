package br.com.mind5.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.info.CompMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiCompMergeToUpdate extends ActionVisitorTemplateMerge<CompInfo, CompInfo> {
	
	public VisiCompMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CompInfo>> getActionClassHook() {
		return StdCompSelect.class;
	}
	
	
	
	@Override protected List<CompInfo> mergeHook(List<CompInfo> recordInfos, List<CompInfo> selectedInfos) {	
		return CompMerger.mergeToUpdate(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
