package br.com.gda.business.orderSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.gda.business.orderSnapshot.info.OrdnapInfo;
import br.com.gda.business.orderSnapshot.info.OrdnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiOrdnapMergeCuslis extends ActionVisitorTemplateMergeV2<OrdnapInfo, CuslisInfo> {
	
	public VisiOrdnapMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}
	
	
	
	@Override protected List<OrdnapInfo> mergeHook(List<OrdnapInfo> recordInfos, List<CuslisInfo> selectedInfos) {	
		return OrdnapMerger.mergeWithCuslis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.DONT_MERGE_WHEN_EMPTY;
	}
}
