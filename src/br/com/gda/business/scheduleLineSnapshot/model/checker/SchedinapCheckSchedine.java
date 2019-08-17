package br.com.gda.business.scheduleLineSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.scheduleLine.info.SchedineInfo;
import br.com.gda.business.scheduleLine.model.checker.SchedineCheckExist;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class SchedinapCheckSchedine implements ModelChecker<SchedinapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SchedineInfo> checker;
	
	
	public SchedinapCheckSchedine(ModelCheckerOption option) {
		checker = new SchedineCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<SchedinapInfo> recordInfos) {
		for (SchedinapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(SchedinapInfo recordInfo) {
		return checker.check(SchedineInfo.copyFrom(recordInfo));
	}

	
	
	@Override public boolean getResult() {
		return checker.getResult();
	}

	
	
	@Override public String getFailMessage() {
		return checker.getFailMessage();
	}

	
	
	@Override public int getFailCode() {
		return checker.getFailCode();
	}
}
