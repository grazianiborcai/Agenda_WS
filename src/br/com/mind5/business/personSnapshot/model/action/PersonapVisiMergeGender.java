package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapMerger;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.decisionTree.GenderRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonapVisiMergeGender extends ActionVisitorTemplateMerge<PersonapInfo, GenderInfo> {
	
	public PersonapVisiMergeGender(DeciTreeOption<PersonapInfo> option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return GenderRootSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> mergeHook(List<PersonapInfo> baseInfos, List<GenderInfo> selectedInfos) {	
		return PersonapMerger.mergeWithGender(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
