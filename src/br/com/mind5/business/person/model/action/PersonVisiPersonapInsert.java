package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.info.PersonMerger;
import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.decisionTree.PersonapRootInsert;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiPersonapInsert extends ActionVisitorTemplateAction<PersonInfo, PersonapInfo> {

	public PersonVisiPersonapInsert(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PersonapInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonapInfo>> getTreeClassHook() {
		return PersonapRootInsert.class;
	}
	
	
	
	protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonapInfo> selectedInfos) {
		return PersonMerger.mergeWithPersonap(baseInfos, selectedInfos);
	}
}
