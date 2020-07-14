package br.com.mind5.business.employeeSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapCopier;
import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.decisionTree.RootAddresnapSelect;
import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.business.employeeSnapshot.info.EmpnapMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiEmpnapMergeAddresnap extends ActionVisitorTemplateMergeV2<EmpnapInfo, AddresnapInfo> {
	
	public VisiEmpnapMergeAddresnap(DeciTreeOption<EmpnapInfo> option) {
		super(option, AddresnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddresnapInfo>> getTreeClassHook() {
		return RootAddresnapSelect.class;
	}
	
	
	
	@Override protected List<AddresnapInfo> toActionClassHook(List<EmpnapInfo> baseInfos) {
		return AddresnapCopier.copyFromEmpnapKey(baseInfos);	
	}
	
	
	
	@Override protected List<EmpnapInfo> mergeHook(List<EmpnapInfo> baseInfos, List<AddresnapInfo> selectedInfos) {	
		return EmpnapMerger.mergeWithAddresnap(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
