package br.com.gda.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgMerger;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;

final class VisiFimgMergeToDelete extends ActionVisitorTemplateMergeV2<FimgInfo, FimgInfo> {
	
	public VisiFimgMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgInfo>> getActionClassHook() {
		return StdFimgSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> recordInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToDelete(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
