package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.business.customerSearch.model.decisionTree.RootCusarchSelectUsername;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetarchMergeCusarch extends ActionVisitorTemplateMerge<PetarchInfo, CusarchInfo> {
	
	public VisiPetarchMergeCusarch(DeciTreeOption<PetarchInfo> option) {
		super(option, CusarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CusarchInfo>> getTreeClassHook() {
		return RootCusarchSelectUsername.class;
	}
	
	
	
	@Override protected List<PetarchInfo> mergeHook(List<PetarchInfo> baseInfos, List<CusarchInfo> selectedInfos) {	
		return PetarchMerger.mergeWithCusarch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
