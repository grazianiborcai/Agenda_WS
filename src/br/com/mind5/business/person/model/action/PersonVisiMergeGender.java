package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.masterData.gender.info.GenderInfo;
import br.com.mind5.masterData.gender.model.decisionTree.GenderRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiMergeGender extends ActionVisitorTemplateMerge<PersonInfo, GenderInfo> {
	
	public PersonVisiMergeGender(DeciTreeOption<PersonInfo> option) {
		super(option, GenderInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<GenderInfo>> getTreeClassHook() {
		return GenderRootSelect.class;
	}
	
	
	
	@Override protected List<PersonInfo> mergeHook(List<PersonInfo> recordInfos, List<GenderInfo> selectedInfos) {	
		return PersonMerger.mergeWithGender(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
