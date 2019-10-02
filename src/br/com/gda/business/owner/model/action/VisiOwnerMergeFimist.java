package br.com.gda.business.owner.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.info.OwnerMerger;
import br.com.gda.file.fileImageList.info.FimistCopier;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOwnerMergeFimist extends ActionVisitorTemplateMergeV2<OwnerInfo, FimistInfo> {
	
	public VisiOwnerMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<OwnerInfo> recordInfos) {
		return FimistCopier.copyFromOwner(recordInfos);	
	}
	
	
	
	@Override protected List<OwnerInfo> mergeHook(List<OwnerInfo> recordInfos, List<FimistInfo> selectedInfos) {	
		return OwnerMerger.mergeWithFimist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
