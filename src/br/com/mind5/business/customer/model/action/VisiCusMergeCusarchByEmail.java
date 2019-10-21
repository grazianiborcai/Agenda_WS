package br.com.mind5.business.customer.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.business.customer.info.CusMerger;
import br.com.mind5.business.customerSearch.info.CusarchCopier;
import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiCusMergeCusarchByEmail extends ActionVisitorTemplateMergeV2<CusInfo, CusarchInfo> {
	
	public VisiCusMergeCusarchByEmail(Connection conn, String schemaName) {
		super(conn, schemaName, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelect.class;
	}
	
	
	
	@Override protected List<CusarchInfo> toActionClassHook(List<CusInfo> recordInfos) {
		return CusarchCopier.copyFromCusEmail(recordInfos);	
	}
	
	
	
	@Override protected List<CusInfo> mergeHook(List<CusInfo> recordInfos, List<CusarchInfo> selectedInfos) {	
		return CusMerger.mergeWithCusarch(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
