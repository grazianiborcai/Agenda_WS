package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonDaoInsert extends ActionStdTemplate<PersonInfo> {

	public StdPersonDaoInsert(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PersonInfo> buildVisitorHook(DeciTreeOption<PersonInfo> option) {
		return new VisiPersonDaoInsert(option);
	}
}
