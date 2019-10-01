package br.com.gda.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgMerger;
import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.file.fileImageSearch.model.decisionTree.RootFimarchSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiFimgMergeFimarch extends ActionVisitorTemplateMergeV2<FimgInfo, FimarchInfo> {
	
	public VisiFimgMergeFimarch(Connection conn, String schemaName) {
		super(conn, schemaName, FimarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimarchInfo>> getTreeClassHook() {
		return RootFimarchSelect.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> recordInfos, List<FimarchInfo> selectedInfos) {	
		return FimgMerger.mergeWithFimarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
