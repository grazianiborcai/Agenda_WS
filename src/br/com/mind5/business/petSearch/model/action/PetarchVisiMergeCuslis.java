package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.customerList.model.decisionTree.CuslisRootSelect;
import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiMergeCuslis extends ActionVisitorTemplateMerge<PetarchInfo, CuslisInfo> {
	
	public PetarchVisiMergeCuslis(DeciTreeOption<PetarchInfo> option) {
		super(option, CuslisInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<CuslisInfo>> getTreeClassHook() {
		return CuslisRootSelect.class;
	}
	
	
	
	@Override protected List<PetarchInfo> mergeHook(List<PetarchInfo> baseInfos, List<CuslisInfo> selectedInfos) {	
		return PetarchMerger.mergeWithCuslis(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
