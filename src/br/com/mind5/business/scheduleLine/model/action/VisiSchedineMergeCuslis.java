package br.com.mind5.business.scheduleLine.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.info.SchedineMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiSchedineMergeCuslis extends ActionVisitorTemplateMergeV2<SchedineInfo, CuslisInfo> {
	
	public VisiSchedineMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}
	
	
	
	@Override protected List<SchedineInfo> mergeHook(List<SchedineInfo> recordInfos, List<CuslisInfo> selectedInfos) {	
		return SchedineMerger.mergeWithCuslis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
