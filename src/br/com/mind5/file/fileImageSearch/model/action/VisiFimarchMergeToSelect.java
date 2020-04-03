package br.com.mind5.file.fileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.info.FimarchMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiFimarchMergeToSelect extends ActionVisitorTemplateMergeV1<FimarchInfo, FimarchInfo> {
	
	public VisiFimarchMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<FimarchInfo>> getActionClassHook() {
		return StdFimarchSelect.class;
	}
	
	
	
	@Override protected List<FimarchInfo> toActionClassHook(List<FimarchInfo> recordInfos) {
		return recordInfos;	
	}
	
	
	
	@Override protected List<FimarchInfo> mergeHook(List<FimarchInfo> recordInfos, List<FimarchInfo> selectedInfos) {	
		return FimarchMerger.mergeToSelect(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
