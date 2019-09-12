package br.com.gda.file.fileImage.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.info.FimgMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.security.username.info.UsernameCopier;
import br.com.gda.security.username.info.UsernameInfo;
import br.com.gda.security.username.model.decisionTree.RootUsernameSelect;

final class VisiFimgMergeUsername extends ActionVisitorTemplateMergeV2<FimgInfo, UsernameInfo> {
	
	public VisiFimgMergeUsername(Connection conn, String schemaName) {
		super(conn, schemaName, UsernameInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<UsernameInfo>> getTreeClassHook() {
		return RootUsernameSelect.class;
	}
	
	
	
	@Override protected List<UsernameInfo> toActionClassHook(List<FimgInfo> recordInfos) {
		return UsernameCopier.copyFromFimg(recordInfos);	
	}
	
	
	
	@Override protected List<FimgInfo> mergeHook(List<FimgInfo> recordInfos, List<UsernameInfo> selectedInfos) {	
		return FimgMerger.mergeWithUsername(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
