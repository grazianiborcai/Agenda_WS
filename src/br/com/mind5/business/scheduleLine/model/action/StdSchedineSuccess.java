package br.com.mind5.business.scheduleLine.model.action;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedineSuccess extends ActionStdSuccessTemplate<SchedineInfo> {
	
	public StdSchedineSuccess(DeciTreeOption<SchedineInfo> option) {
		super(option);
	}
}
