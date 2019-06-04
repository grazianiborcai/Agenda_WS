package br.com.gda.business.employeeSnapshot.model.action;

import java.sql.Connection;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapCopier;
import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.gda.business.employeeSnapshot.info.EmpnapInfo;
import br.com.gda.business.employeeSnapshot.info.EmpnapMerger;
import br.com.gda.model.action.ActionVisitorTemplateMergeV2;
import br.com.gda.model.decisionTree.DeciTree;

final class VisiEmpapMergeAddresnap extends ActionVisitorTemplateMergeV2<EmpnapInfo, AddresnapInfo> {
	
	public VisiEmpapMergeAddresnap(Connection conn, String schemaName) {
		super(conn, schemaName, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<EmpnapInfo> recordInfos) {
		return AddresnapCopier.copyFromEmpnapKey(recordInfos);	
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> recordInfos, List<AddresnapInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithAddresnap(selectedInfos, recordInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return ActionVisitorTemplateMergeV2.MERGE_WHEN_EMPTY;
	}
}
