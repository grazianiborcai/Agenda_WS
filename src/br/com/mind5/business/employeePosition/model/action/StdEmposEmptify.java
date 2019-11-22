package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;

public final class StdEmposEmptify extends ActionStdSuccessTemplate<EmposInfo> {
	public StdEmposEmptify() {
		super(EmposInfo.class);
	}
}
