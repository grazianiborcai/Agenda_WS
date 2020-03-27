package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeList.model.decisionTree.RootStolisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeStolis extends ActionVisitorTemplateMerge<EmpwotmInfo, StolisInfo> {
	
	public VisiEmpwotmMergeStolis(Connection conn, String schemaName) {
		super(conn, schemaName, StolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StolisInfo>> getTreeClassHook() {
		return RootStolisSelect.class;
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<StolisInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithStolis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.MERGE_WHEN_EMPTY;
	}
}
