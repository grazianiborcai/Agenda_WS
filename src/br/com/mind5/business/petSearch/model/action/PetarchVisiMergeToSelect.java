package br.com.mind5.business.petSearch.model.action;

import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.business.petSearch.info.PetarchMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetarchVisiMergeToSelect extends ActionVisitorTemplateMerge<PetarchInfo, PetarchInfo> {
	
	public PetarchVisiMergeToSelect(DeciTreeOption<PetarchInfo> option) {
		super(option, PetarchInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PetarchInfo>> getVisitorClassHook() {
		return PetarchVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PetarchInfo> mergeHook(List<PetarchInfo> baseInfos, List<PetarchInfo> selectedInfos) {	
		return PetarchMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
