package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchCopier;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.business.storeWorkTimeSearch.model.decisionTree.RootStowotarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeStowotarch extends ActionVisitorTemplateMergeV2<EmpwotmInfo, StowotarchInfo> {
	
	public VisiEmpwotmMergeStowotarch(Connection conn, String schemaName) {
		super(conn, schemaName, StowotarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotarchInfo>> getTreeClassHook() {
		return RootStowotarchSelect.class;
	}
	
	
	
	@Override protected List<StowotarchInfo> toActionClassHook(List<EmpwotmInfo> baseInfos) {
		return StowotarchCopier.copyFromEmpwotm(baseInfos);
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> baseInfos, List<StowotarchInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithStowotarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
