package br.com.mind5.business.scheduleLine.model.checker;

import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class SchedineCheckMatore implements ModelChecker<SchedineInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatoreInfo> checker;
	
	
	public SchedineCheckMatore(ModelCheckerOption option) {
		checker = new MatoreCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<SchedineInfo> recordInfos) {
		for (SchedineInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(SchedineInfo recordInfo) {
		return checker.check(MatoreInfo.copyFrom(recordInfo));
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
