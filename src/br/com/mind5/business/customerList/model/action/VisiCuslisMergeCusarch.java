package br.com.mind5.business.customerList.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.info.CuslisMerger;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCuslisMergeCusarch extends ActionVisitorTemplateMerge<CuslisInfo, CusarchInfo> {
	
	public VisiCuslisMergeCusarch(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> mergeHook(List<CuslisInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return CuslisMerger.mergeWithCusarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMerge.DONT_MERGE_WHEN_EMPTY;
	}
}
