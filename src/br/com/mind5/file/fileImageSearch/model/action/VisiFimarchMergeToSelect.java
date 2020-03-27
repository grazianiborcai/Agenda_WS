package br.com.mind5.file.fileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiFimarchMergeToSelect extends ActionVisitorTemplateMerge<FimarchInfo, FimarchInfo> {
	
	public VisiFimarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimarchInfo>> getActionClassHook() {
		return StdFimarchSelect.class;
	}
	
	
	
	@Override protected List<FimarchInfo> toActionClassHook(List<FimarchInfo> recordInfos) {
		return recordInfos;	
	}
	
	
	
	@Override protected List<FimarchInfo> mergeHook(List<FimarchInfo> recordInfos, List<FimarchInfo> selectedInfos) {	
		return FimarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
