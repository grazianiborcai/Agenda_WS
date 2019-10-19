package br.com.gda.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.business.storeList.info.StolisMerger;
import br.com.gda.file.fileImageList.info.FimistCopier;
import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiStolisMergeFimist extends ActionVisitorTemplateMergeV2<StolisInfo, FimistInfo> {
	
	public VisiStolisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<StolisInfo> recordInfos) {
		return FimistCopier.copyFromStolis(recordInfos);	
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> recordInfos, List<FimistInfo> selectedInfos) {	
		return StolisMerger.mergeWithFimist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
