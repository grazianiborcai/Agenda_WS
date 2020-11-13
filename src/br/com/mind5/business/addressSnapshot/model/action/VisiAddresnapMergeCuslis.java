package br.com.mind5.business.addressSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.info.AddresnapMerger;
import br.com.mind5.business.customerList.info.CuslisCopier;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.RootCuslisSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiAddresnapMergeCuslis extends ActionVisitorTemplateMerge<AddresnapInfo, CuslisInfo> {
	
	public VisiAddresnapMergeCuslis(DeciTreeOption<AddresnapInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return RootCuslisSelect.class;
	}

	
	
	protected List<CuslisInfo> toActionClassHook(List<AddresnapInfo> baseInfos) {
		return CuslisCopier.copyFromAddresnap(baseInfos);	
	}	
	
	
	@Override protected List<AddresnapInfo> mergeHook(List<AddresnapInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return AddresnapMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
