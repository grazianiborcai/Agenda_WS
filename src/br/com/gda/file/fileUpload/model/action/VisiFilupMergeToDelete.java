package br.com.gda.file.fileUpload.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.info.FilupMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiFilupMergeToDelete extends ActionVisitorTemplateMergeV2<FilupInfo, FilupInfo> {
	
	public VisiFilupMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, FilupInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FilupInfo>> getActionClassHook() {
		return StdFilupSelect.class;
	}
	
	
	
	@Override protected List<FilupInfo> mergeHook(List<FilupInfo> recordInfos, List<FilupInfo> selectedInfos) {	
		return FilupMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
