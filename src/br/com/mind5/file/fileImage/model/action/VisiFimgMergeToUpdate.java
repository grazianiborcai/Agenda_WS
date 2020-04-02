package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;

final class VisiFimgMergeToUpdate extends ActionVisitorTemplateMerge<FimgInfo, FimgInfo> {
	
	public VisiFimgMergeToUpdate(Connection conn, String schemaName) {
		super(conn, schemaName, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<FimgInfo>> getActionClassHook() {
		return StdFimgSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> toActionClassHook(List<FimgInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> baseInfos, List<FimgInfo> selectedInfos) {	
		return FimgMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
