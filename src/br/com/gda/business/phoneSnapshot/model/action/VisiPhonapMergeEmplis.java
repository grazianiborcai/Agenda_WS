package br.com.gda.business.phoneSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.employeeList.info.EmplisCopier;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.business.phoneSnapshot.info.PhonapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

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
