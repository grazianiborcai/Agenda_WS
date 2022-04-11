package br.com.mind5.business.personBio.model.action;

import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.info.PerbioMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PerbioVisiMergeToUpdate extends ActionVisitorTemplateMerge<PerbioInfo, PerbioInfo> {
	
	public PerbioVisiMergeToUpdate(DeciTreeOption<PerbioInfo> option) {
		super(option, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PerbioInfo>> getVisitorClassHook() {
		return PerbioVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PerbioInfo> toActionClassHook(List<PerbioInfo> baseInfos) {
		return baseInfos;	
	}	
	
	
	
	@Override protected List<PerbioInfo> mergeHook(List<PerbioInfo> baseInfos, List<PerbioInfo> selectedInfos) {	
		return PerbioMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
