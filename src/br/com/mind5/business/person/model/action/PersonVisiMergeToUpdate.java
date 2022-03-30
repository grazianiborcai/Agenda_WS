package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.action.ActionVisitorTemplateMerge;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiMergeToUpdate extends ActionVisitorTemplateMerge<PersonInfo, PersonInfo> {
	
	public PersonVisiMergeToUpdate(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends ActionVisitor<PersonInfo>> getVisitorClassHook() {
		return PersonVisiDaoSelect.class;
	}
	
	
	
	@Override protected List<PersonInfo> mergeHook(List<PersonInfo> baseInfos, List<PersonInfo> selectedInfos) {	
		return PersonMerger.mergeToUpdate(baseInfos, selectedInfos);
	}
	
	
	
	@Override protected boolean shouldMergeWhenEmptyHook() {
		return super.DONT_MERGE_WHEN_EMPTY;
	}
}
