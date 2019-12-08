package br.com.mind5.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.file.fileImage.info.FimgInfo;
import br.com.mind5.file.fileImage.info.FimgMerger;
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.fileImageSearch.model.decisionTree.RootFimarchSelectMat;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiFimgMergeFimarchMat extends ActionVisitorTemplateMergeV2<FimgInfo, FimarchInfo> {
	
	public VisiFimgMergeFimarchMat(Connection conn, String schemaName) {
		super(conn, schemaName, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimarchInfo>> getTreeClassHook() {
		return RootFimarchSelectMat.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> recordInfos, List<FimarchInfo> selectedInfos) {	
		return FimgMerger.mergeWithFimarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
