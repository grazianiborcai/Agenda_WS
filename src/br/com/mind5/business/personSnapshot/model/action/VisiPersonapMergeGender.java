package br.com.mind5.business.personSnapshot.model.action;

import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.info.PersonapMerger;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.decisionTree.RootGenderSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMergeV2;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class VisiPersonapMergeGender extends ActionVisitorTemplateMergeV2<PersonapInfo, GenderInfo> {
	
	public VisiPersonapMergeGender(DeciTreeOption<PersonapInfo> option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return RootGenderSelect.class;
	}
	
	
	
	@Override protected List<PersonapInfo> mergeHook(List<PersonapInfo> baseInfos, List<GenderInfo> selectedInfos) {	
		return PersonapMerger.mergeWithGender(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
