package br.com.mind5.business.scheduleMoviment.model.action;

import br.com.mind5.business.scheduleMoviment.info.SchedovmInfo;
import br.com.mind5.model.action.commom.ActionStdSuccessTemplate;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public class StdSchedovmSuccess extends ActionStdSuccessTemplate<SchedovmInfo> {
	
	public StdSchedovmSuccess(DeciTreeOption<SchedovmInfo> option) {
		super(option);
	}
}
