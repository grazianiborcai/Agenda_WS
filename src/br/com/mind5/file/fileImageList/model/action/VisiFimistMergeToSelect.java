package br.com.mind5.file.fileImageList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.info.FimistMerger;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV1;

final class VisiFimistMergeToSelect extends ActionVisitorTemplateMergeV1<FimistInfo, FimistInfo> {
	
	public VisiFimistMergeToSelect(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStdV1<FimistInfo>> getActionClassHook() {
		return StdFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<FimistInfo> baseInfos) {
		return baseInfos;	
	}
	
	
	
	@Override protected List<FimistInfo> mergeHook(List<FimistInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return FimistMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV1.DONT_MERGE_WHEN_EMPTY;
	}
}
