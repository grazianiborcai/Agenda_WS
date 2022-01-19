package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchMerger;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPetarchMergeToSelect extends ActionVisitorTemplateMerge<PetarchInfo, PetarchInfo> {
	
	public VisiPetarchMergeToSelect(DeciTreeOption<PetarchInfo> option) {
		super(option, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionStd<PetarchInfo>> getActionClassHook() {
		return StdPetarchDaoSelect.class;
	}
	
	
	
	@Override protected List<PetarchInfo> mergeHook(List<PetarchInfo> baseInfos, List<PetarchInfo> selectedInfos) {	
		return PetarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
