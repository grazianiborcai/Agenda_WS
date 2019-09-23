package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.customerList.info.CuslisCopier;
import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiPhonapMergeCuslis extends ActionVisitorTemplateMergeV2<PhonapInfo, CuslisInfo> {
	
	public VisiPhonapMergeCuslis(Connection conn, String schemaName) {
		super(conn, schemaName, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}

	
	
	protected List<CuslisInfo> toActionClassHook(List<PhonapInfo> recordInfos) {
		return CuslisCopier.copyFromPhonap(recordInfos);	
	}	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> recordInfos, List<CuslisInfo> selectedInfos) {	
		return PhonapMerger.mergeWithCuslis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
