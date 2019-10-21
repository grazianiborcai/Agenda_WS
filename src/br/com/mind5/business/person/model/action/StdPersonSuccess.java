package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonSuccess extends ActionStdSuccessTemplate<PersonInfo> {
	public StdPersonSuccess(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
}
