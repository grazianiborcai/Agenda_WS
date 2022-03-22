package br.com.mind5.business.employee.model.action;

import java.util.List;

import br.com.mind5.business.address.info.AddressCopier;
import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.decisionTree.AddressRootSearch;
import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employee.info.EmpMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class EmpVisiMergeAddress extends ActionVisitorTemplateMerge<EmpInfo, AddressInfo> {
	
	public EmpVisiMergeAddress(DeciTreeOption<EmpInfo> option) {
		super(option, AddressInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<AddressInfo>> getTreeClassHook() {
		return AddressRootSearch.class;
	}
	
	
	
	@Override protected List<AddressInfo> toActionClassHook(List<EmpInfo> baseInfos) {
		return AddressCopier.copyFromEmpKey(baseInfos);	
	}
	
	
	
	@Override protected List<EmpInfo> mergeHook(List<EmpInfo> baseInfos, List<AddressInfo> selectedInfos) {	
		return EmpMerger.mergeWithAddress(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
