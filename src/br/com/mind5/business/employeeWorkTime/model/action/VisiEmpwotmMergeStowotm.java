package br.com.mind5.business.employeeWorkTime.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.business.employeeWorkTime.info.EmpwotmMerger;
import br.com.mind5.business.storeWorkTime.info.StowotmCopier;
import br.com.mind5.business.storeWorkTime.info.StowotmInfo;
import br.com.mind5.business.storeWorkTime.model.decisionTree.RootStowotmSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiEmpwotmMergeStowotm extends ActionVisitorTemplateMergeV2<EmpwotmInfo, StowotmInfo> {
	
	public VisiEmpwotmMergeStowotm(Connection conn, String schemaName) {
		super(conn, schemaName, StowotmInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<StowotmInfo>> getTreeClassHook() {
		return RootStowotmSelect.class;
	}
	
	
	
	@Override protected List<StowotmInfo> toActionClassHook(List<EmpwotmInfo> recordInfos) {
		return StowotmCopier.copyFromEmpwotm(recordInfos);
	}
	
	
	
	@Override protected List<EmpwotmInfo> mergeHook(List<EmpwotmInfo> recordInfos, List<StowotmInfo> selectedInfos) {	
		return EmpwotmMerger.mergeWithStowotm(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
