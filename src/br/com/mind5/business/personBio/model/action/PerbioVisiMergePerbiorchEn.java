package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioMerger;
import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.business.personBioSearch.model.decisionTree.PerbiorchRootSelectEn;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiMergePerbiorchEn extends ActionVisitorTemplateMerge<PerbioInfo, PerbiorchInfo> {
	
	public PerbioVisiMergePerbiorchEn(DeciTreeOption<PerbioInfo> option) {
		super(option, PerbiorchInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbiorchInfo>> getTreeClassHook() {
		return PerbiorchRootSelectEn.class;
	}
	
	
	
	@Override protected List<PerbioInfo> mergeHook(List<PerbioInfo> baseInfos, List<PerbiorchInfo> selectedInfos) {	
		return PerbioMerger.mergeWithPerbiorch(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
