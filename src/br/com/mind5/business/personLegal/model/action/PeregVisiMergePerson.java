package br.com.mind5.business.personLegal.model.action;

import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.business.personLegal.info.PeregMerger;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonRootSelect;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PeregVisiMergePerson extends ActionVisitorTemplateMerge<PeregInfo, PersonInfo> {
	
	public PeregVisiMergePerson(DeciTreeOption<PeregInfo> option) {
		super(option, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonRootSelect.class;
	}
	
	
	
	@Override protected List<PeregInfo> mergeHook(List<PeregInfo> baseInfos, List<PersonInfo> selectedInfos) {	
		return PeregMerger.mergeWithPerson(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.MERGE_WHEN_EMPTY;
	}
}
