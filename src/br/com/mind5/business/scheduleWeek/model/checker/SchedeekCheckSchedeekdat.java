package br.com.mind5.business.scheduleWeek.model.checker;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.checker.SchedeekdatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedeekCheckSchedeekdat extends ModelCheckerTemplateForward<SchedeekInfo, SchedeekdatInfo> {
	
	public SchedeekCheckSchedeekdat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedeekdatInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedeekdatCheckExist(option);
	}
	
	
	
	@Override protected SchedeekdatInfo toForwardClass(SchedeekInfo baseRecord) {
		return SchedeekdatInfo.copyFrom(baseRecord);
	}
}
