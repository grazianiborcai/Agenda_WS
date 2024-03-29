package br.com.mind5.business.phoneSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisCopier;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSelect;
import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.business.phoneSnapshot.info.PhonapMerger;

import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PhonapVisiMergeCuslis extends ActionVisitorTemplateMerge<PhonapInfo, CuslisInfo> {
	
	public PhonapVisiMergeCuslis(DeciTreeOption<PhonapInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSelect.class;
	}

	
	
	protected List<CuslisInfo> toActionClassHook(List<PhonapInfo> baseInfos) {
		return CuslisCopier.copyFromPhonap(baseInfos);	
	}	
	
	
	@Override protected List<PhonapInfo> mergeHook(List<PhonapInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return PhonapMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
