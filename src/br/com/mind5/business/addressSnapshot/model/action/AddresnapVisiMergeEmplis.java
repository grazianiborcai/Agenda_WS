package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.business.employeeList.info.EmplisCopier;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeList.model.decisionTree.EmplisRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class AddresnapVisiMergeEmplis extends ActionVisitorTemplateMerge<AddresnapInfo, EmplisInfo> {
	
	public AddresnapVisiMergeEmplis(DeciTreeOption<AddresnapInfo> option) {
		super(option, EmplisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<EmplisInfo>> getTreeClassHook() {
		return EmplisRootSelect.class;
	}

	
	
	protected List<EmplisInfo> toActionClassHook(List<AddresnapInfo> baseInfos) {
		return EmplisCopier.copyFromAddresnap(baseInfos);	
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<EmplisInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithEmplis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
