package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.business.personBio.model.decisionTree.PerbioRootSearchPerson;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiMergePerbio extends ActionVisitorTemplateMerge<PersonInfo, PerbioInfo> {
	
	public PersonVisiMergePerbio(DeciTreeOption<PersonInfo> option) {
		super(option, PerbioInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PerbioInfo>> getTreeClassHook() {
		return PerbioRootSearchPerson.class;
	}
	
	
	
	@Override protected List<PersonInfo> mergeHook(List<PersonInfo> recordInfos, List<PerbioInfo> selectedInfos) {	
		return PersonMerger.mergeWithPerbio(recordInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
