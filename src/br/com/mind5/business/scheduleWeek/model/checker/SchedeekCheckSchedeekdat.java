package br.com.mind5.business.scheduleWeek.model.checker;

import br.com.mind5.business.scheduleWeek.info.SchedeekInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.scheduleWeekData.model.checker.SchedeekdatCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class SchedeekCheckSchedeekdat extends ModelCheckerTemplateForwardV2<SchedeekInfo, SchedeekdatInfo> {
	
	public SchedeekCheckSchedeekdat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<SchedeekdatInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedeekdatCheckExist(option);
	}
	
	
	
	@Override protected SchedeekdatInfo toForwardClass(SchedeekInfo baseRecord) {
		return SchedeekdatInfo.copyFrom(baseRecord);
	}
}
