package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonNodeSnapshot;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiNodeSnapshot extends ActionVisitorTemplateAction<PersonInfo, PersonInfo> {

	public PersonVisiNodeSnapshot(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonNodeSnapshot.class;
	}
	
	
	
	@Override protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonInfo> results) {
		return results;
	}
}
