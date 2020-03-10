package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;

final class VisiFimgMergeToDelete extends ActionVisitorTemplateMergeV2<FimgInfo, FimgInfo> {
	
	public VisiFimgMergeToDelete(Connection conn, String schemaName) {
		super(conn, schemaName, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<FimgInfo>> getActionClassHook() {
		return StdFimgSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToDelete(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
