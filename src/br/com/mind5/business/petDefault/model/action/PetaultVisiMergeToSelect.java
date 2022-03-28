package br.com.mind5.business.petDefault.model.action;

import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.business.petDefault.info.PetaultMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetaultVisiMergeToSelect extends ActionVisitorTemplateMerge<PetaultInfo, PetaultInfo> {
	
	public PetaultVisiMergeToSelect(DeciTreeOption<PetaultInfo> option) {
		super(option, PetaultInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PetaultInfo>> getVisitorClassHook() {
		return PetaultVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PetaultInfo> mergeHook(List<PetaultInfo> baseInfos, List<PetaultInfo> selectedInfos) {	
		return PetaultMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
