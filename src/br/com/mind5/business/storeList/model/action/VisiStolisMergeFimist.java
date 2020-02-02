package br.com.mind5.business.storeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.info.StolisMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSearch;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiStolisMergeFimist extends ActionVisitorTemplateMergeV2<StolisInfo, FimistInfo> {
	
	public VisiStolisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSearch.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<StolisInfo> baseInfos) {
		return FimistCopier.copyFromStolis(baseInfos);	
	}
	
	
	
	@Override protected List<StolisInfo> mergeHook(List<StolisInfo> baseInfos, List<FimistInfo> selectedInfos) {	
		return StolisMerger.mergeWithFimist(selectedInfos, baseInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
