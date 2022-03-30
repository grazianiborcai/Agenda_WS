package br.com.mind5.business.person.model.action;

import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.decisionTree.PersonNodeCpfL1;
import br.com.mind5.model.action.ActionVisitorTemplateAction;
import br.com.mind5.model.decisionTree.DeciTree;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class PersonVisiNodeCpfL1 extends ActionVisitorTemplateAction<PersonInfo, PersonInfo> {

	public PersonVisiNodeCpfL1(DeciTreeOption<PersonInfo> option) {
		super(option, PersonInfo.class, PersonInfo.class);
	}
	
	
	
	@Override protected Class<? extends DeciTree<PersonInfo>> getTreeClassHook() {
		return PersonNodeCpfL1.class;
	}
	
	
	
	@Override protected List<PersonInfo> toBaseClassHook(List<PersonInfo> baseInfos, List<PersonInfo> results) {
		return results;
	}
}
