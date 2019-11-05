package br.com.mind5.business.employeeList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.info.EmplisMerger;
import br.com.mind5.file.fileImageList.info.FimistCopier;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.decisionTree.RootFimistSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmplisMergeFimist extends ActionVisitorTemplateMergeV2<EmplisInfo, FimistInfo> {
	
	public VisiEmplisMergeFimist(Connection conn, String schemaName) {
		super(conn, schemaName, FimistInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<FimistInfo>> getTreeClassHook() {
		return RootFimistSelect.class;
	}
	
	
	
	@Override protected List<FimistInfo> toActionClassHook(List<EmplisInfo> recordInfos) {
		return FimistCopier.copyFromEmplis(recordInfos);	
	}
	
	
	
	@Override protected List<EmplisInfo> mergeHook(List<EmplisInfo> recordInfos, List<FimistInfo> selectedInfos) {	
		return EmplisMerger.mergeWithFimist(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
