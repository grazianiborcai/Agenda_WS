package br.com.gda.business.company.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.business.company.info.CompMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiCompMergeToSelect extends ActionVisitorTemplateMergeV2<CompInfo, CompInfo> {
	
	public VisiCompMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, CompInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<CompInfo>> getActionClassHook() {
		return StdCompSelect.class;
	}
	
	
	
	@Override protected List<CompInfo> mergeHook(List<CompInfo> recordInfos, List<CompInfo> selectedInfos) {	
		return CompMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
