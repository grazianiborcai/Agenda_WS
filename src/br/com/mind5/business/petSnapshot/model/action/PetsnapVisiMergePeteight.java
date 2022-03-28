package br.com.mind5.business.petSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.business.petSnapshot.info.PetsnapMerger;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;
import br.com.mind5.masterData.petWeight.model.decisionTree.RootPeteightSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PetsnapVisiMergePeteight extends ActionVisitorTemplateMerge<PetsnapInfo, PeteightInfo> {
	
	public PetsnapVisiMergePeteight(DeciTreeOption<PetsnapInfo> option) {
		super(option, PeteightInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PeteightInfo>> getTreeClassHook() {
		return RootPeteightSelect.class;
	}
	
	
	
	@Override protected List<PetsnapInfo> mergeHook(List<PetsnapInfo> baseInfos, List<PeteightInfo> selectedInfos) {	
		return PetsnapMerger.mergeWithPeteight(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
