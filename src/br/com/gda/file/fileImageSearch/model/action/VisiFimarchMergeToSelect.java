package br.com.gda.file.fileImageSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.file.fileImageSearch.info.FimarchMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiFimarchMergeToSelect extends ActionVisitorTemplateMergeV2<FimarchInfo, FimarchInfo> {
	
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
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
