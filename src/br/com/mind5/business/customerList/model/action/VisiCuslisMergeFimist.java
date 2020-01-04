package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.info.CuslisMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCuslisMergeFimist extends ActionVisitorTemplateMergeV2<CuslisInfo, FimistInfo> {
	
	public VisiCuslisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<CuslisInfo> recordInfos) {
		return FimistCopier.copyFromCuslis(recordInfos);	
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> recordInfos, List<FimistInfo> selectedInfos) {	
		return CuslisMerger.mergeWithFimist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
