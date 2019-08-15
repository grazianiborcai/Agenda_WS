package br.com.gda.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.customerList.info.CuslisMerger;
import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.business.personList.model.decisionTree.RootPersolisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCuslisMergePersolis extends ActionVisitorTemplateMergeV2<CuslisInfo, PersolisInfo> {
	
	public VisiCuslisMergePersolis(Connection conn, String schemaName) {
		super(conn, schemaName, PersolisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersolisInfo>> getTreeClassHook() {
		return RootPersolisSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> recordInfos, List<PersolisInfo> selectedInfos) {	
		return CuslisMerger.mergeWithPersolis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
