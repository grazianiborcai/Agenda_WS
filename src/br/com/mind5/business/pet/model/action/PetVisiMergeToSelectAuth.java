package br.com.mind5.business.pet.model.action;

import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.business.pet.info.PetMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetVisiMergeToSelectAuth extends ActionVisitorTemplateMerge<PetInfo, PetInfo> {
	
	public PetVisiMergeToSelectAuth(DeciTreeOption<PetInfo> option) {
		super(option, PetInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PetInfo>> getVisitorClassHook() {
		return PetVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PetInfo> toActionClassHook(List<PetInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<PetInfo> mergeHook(List<PetInfo> baseInfos, List<PetInfo> selectedInfos) {	
		return PetMerger.mergeToSelectAuth(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
