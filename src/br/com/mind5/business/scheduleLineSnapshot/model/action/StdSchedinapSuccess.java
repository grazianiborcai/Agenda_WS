package br.com.mind5.business.scheduleLineSnapshot.model.action;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedinapSuccess extends ActionStdSuccessTemplate<SchedinapInfo> {
	
	public StdSchedinapSuccess(DeciTreeOption<SchedinapInfo> option) {
		super(option);
	}
}
