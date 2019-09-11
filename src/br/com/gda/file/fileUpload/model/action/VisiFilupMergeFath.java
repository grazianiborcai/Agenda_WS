package br.com.gda.file.fileUpload.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.file.filePath.model.decisionTree.RootFathSelect;
import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.info.FilupMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiFilupMergeFath extends ActionVisitorTemplateMergeV2<FilupInfo, FathInfo> {
	
	public VisiFilupMergeFath(Connection conn, String schemaName) {
		super(conn, schemaName, FathInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FathInfo>> getTreeClassHook() {
		return RootFathSelect.class;
	}
	
	
	
	@Override protected List<FilupInfo> mergeHook(List<FilupInfo> recordInfos, List<FathInfo> selectedInfos) {	
		return FilupMerger.mergeWithFath(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
