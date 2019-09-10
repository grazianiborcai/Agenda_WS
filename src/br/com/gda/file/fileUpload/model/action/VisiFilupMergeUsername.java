package br.com.gda.file.fileUpload.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileUpload.info.FilupInfo;
import br.com.gda.file.fileUpload.info.FilupMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiFilupMergeUsername extends ActionVisitorTemplateMergeV2<FilupInfo, UsernameInfo> {
	
	public VisiFilupMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<FilupInfo> recordInfos) {
		return UsernameCopier.copyFromFilup(recordInfos);	
	}
	
	
	
	@Override protected List<FilupInfo> mergeHook(List<FilupInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return FilupMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
