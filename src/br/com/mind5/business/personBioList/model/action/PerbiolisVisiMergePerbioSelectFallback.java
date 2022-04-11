package br.com.mind5.business.personBioList.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.PerbioRootSelectFallback;
import br.com.mind5.business.personBioList.info.PerbiolisInfo;
import br.com.mind5.business.personBioList.info.PerbiolisMerger;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbiolisVisiMergePerbioSelectFallback extends ActionVisitorTemplateMerge<PerbiolisInfo, PerbioInfo> {
	
	public PerbiolisVisiMergePerbioSelectFallback(DeciTreeOption<PerbiolisInfo> option) {
		super(option, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return PerbioRootSelectFallback.class;
	}
	
	
	
	@Override protected List<PerbiolisInfo> mergeHook(List<PerbiolisInfo> baseInfos, List<PerbioInfo> selectedInfos) {	
		return PerbiolisMerger.mergeWithPerbio(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
