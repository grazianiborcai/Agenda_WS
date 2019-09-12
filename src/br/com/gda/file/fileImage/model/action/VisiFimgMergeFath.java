package br.com.gda.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgMerger;
import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.model.decisionTree.RootFathSelectImage;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiFimgMergeFath extends ActionVisitorTemplateMergeV2<FimgInfo, FathInfo> {
	
	public VisiFimgMergeFath(Connection conn, String schemaName) {
		super(conn, schemaName, FathInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FathInfo>> getTreeClassHook() {
		return RootFathSelectImage.class;
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> recordInfos, List<FathInfo> selectedInfos) {	
		return FimgMerger.mergeWithFath(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
