package br.com.gda.business.addressSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.info.AddresnapMerger;
import br.com.gda.business.employeeList.info.EmplisCopier;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.employeeList.model.decisionTree.RootEmplisSelect;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiAddresnapMergeEmplis extends ActionVisitorTemplateMergeV2<AddresnapInfo, EmplisInfo> {
	
	public VisiAddresnapMergeEmplis(Connection conn, String schemaName) {
		super(conn, schemaName, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return RootEmplisSelect.class;
	}

	
	
	protected List<EmplisInfo> toActionClassHook(List<AddresnapInfo> recordInfos) {
		return EmplisCopier.copyFromAddresnap(recordInfos);	
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> recordInfos, List<EmplisInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithEmplis(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
