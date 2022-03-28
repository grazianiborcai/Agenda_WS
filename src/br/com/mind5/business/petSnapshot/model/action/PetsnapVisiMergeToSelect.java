package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.info.PetsnapMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetsnapVisiMergeToSelect extends ActionVisitorTemplateMerge<PetsnapInfo, PetsnapInfo> {
	
	public PetsnapVisiMergeToSelect(DeciTreeOption<PetsnapInfo> option) {
		super(option, PetsnapInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PetsnapInfo>> getVisitorClassHook() {
		return PetsnapVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PetsnapInfo> toActionClassHook(List<PetsnapInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<PetsnapInfo> mergeHook(List<PetsnapInfo> baseInfos, List<PetsnapInfo> selectedInfos) {	
		return PetsnapMerger.mergeToSelect(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
