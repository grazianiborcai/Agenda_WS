package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.file.fileImage.info.FimgCopier;
import br.com.gda.file.fileImage.info.FimgInfo;
import br.com.gda.file.fileImage.model.decisionTree.RootFimgSearch;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeFimg extends ActionVisitorTemplateMergeV2<OwnerInfo, FimgInfo> {
	
	public VisiOwnerMergeFimg(Connection conn, String schemaName) {
		super(conn, schemaName, FimgInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimgInfo>> getTreeClassHook() {
		return RootFimgSearch.class;
	}
	
	
	
	@Override protected List<FimgInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return FimgCopier.copyFromOwner(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<FimgInfo> selectedInfos) {	
		return OwnerMerger.mergeWithFimg(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
