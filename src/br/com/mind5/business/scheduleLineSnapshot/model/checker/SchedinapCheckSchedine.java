package br.com.mind5.business.scheduleLineSnapshot.model.checker;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class SchedinapCheckSchedine extends ModelCheckerTemplateForward<SchedinapInfo, SchedineInfo> {
	
	public SchedinapCheckSchedine(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<SchedineInfo> getCheckerHook(ModelCheckerOption option) {
		return new SchedineCheckExist(option);
	}
	
	
	
	@Override protected SchedineInfo toForwardClass(SchedinapInfo baseRecord) {
		return SchedineInfo.copyFrom(baseRecord);
	}
}
