package br.com.gda.business.person.model.action;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.model.action.commom.ActionStdSuccessTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class StdPersonSuccess extends ActionStdSuccessTemplate<PersonInfo> {
	public StdPersonSuccess(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
}
