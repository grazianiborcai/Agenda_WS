package br.com.mind5.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisCopier;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;

final class VisiPhonapMergeEmplis extends ActionVisitorTemplateMergeV2<PhonapInfo, EmplisInfo> {
	
	public VisiPhonapMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}

	
	
	protected List<EmplisInfo> toActionClassHook(List<PhonapInfo> recordInfos) {
		return EmplisCopier.copyFromPhonap(recordInfos);	
	}	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return PhonapMerger.mergeWithEmplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
