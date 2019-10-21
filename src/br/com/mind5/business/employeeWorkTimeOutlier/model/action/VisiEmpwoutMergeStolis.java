package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutMerger;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwoutMergeStolis extends ActionVisitorTemplateMergeV2<EmpwoutInfo, StolisInfo> {
	
	public VisiEmpwoutMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<EmpwoutInfo> mergeHook(List<EmpwoutInfo> recordInfos, List<StolisInfo> selectedInfos) {	
		return EmpwoutMerger.mergeWithStolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
