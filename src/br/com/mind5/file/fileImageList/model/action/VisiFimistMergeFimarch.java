package br.com.mind5.file.fileImageList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.info.FimistMerger;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiFimistMergeFimarch extends ActionVisitorTemplateMerge<FimistInfo, FimarchInfo> {
	
	public VisiFimistMergeFimarch(Connection conn, String schemaName) {
		super(conn, schemaName, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimarchInfo>> getTreeClassHook() {
		return RootFimarchSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> mergeHook(List<FimistInfo> baseInfos, List<FimarchInfo> selectedInfos) {	
		return FimistMerger.mergeWithFimarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
