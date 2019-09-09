package br.com.gda.business.scheduleWeek.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerList.info.CuslisCopier;
import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.gda.business.scheduleWeek.info.SchedeekInfo;
import br.com.gda.business.scheduleWeek.info.SchedeekMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiSchedeekMergeCuslis extends ActionVisitorTemplateMergeV2<SchedeekInfo, CuslisInfo> {
	
	public VisiSchedeekMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}
	
	
	
	@Override protected List<CuslisInfo> toActionClassHook(List<SchedeekInfo> recordInfos) {
		return CuslisCopier.copyFromSchedeek(recordInfos);
	}
	
	
	
	@Override protected List<SchedeekInfo> mergeHook(List<SchedeekInfo> recordInfos, List<CuslisInfo> selectedInfos) {	
		return SchedeekMerger.mergeWithCuslis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
