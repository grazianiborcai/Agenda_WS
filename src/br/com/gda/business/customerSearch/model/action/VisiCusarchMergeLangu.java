package br.com.gda.business.customerSearch.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.business.customerSearch.info.CusarchMerger;
import br.com.gda.business.masterData.info.LanguInfo;
import br.com.gda.business.masterData.model.decisionTree.RootLanguSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiCusarchMergeLangu extends ActionVisitorTemplateMergeV2<CusarchInfo, LanguInfo> {
	
	public VisiCusarchMergeLangu(Connection conn, String schemaName) {
		super(conn, schemaName, LanguInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<LanguInfo>> getTreeClassHook() {
		return RootLanguSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> mergeHook(List<CusarchInfo> recordInfos, List<LanguInfo> selectedInfos) {	
		return CusarchMerger.mergeWithLangu(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
