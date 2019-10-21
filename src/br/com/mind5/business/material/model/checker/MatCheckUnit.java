package br.com.mind5.business.material.model.checker;

import java.util.List;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.business.masterData.model.checker.MatUnitCheckExist;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;

public final class MatCheckUnit implements ModelChecker<MatInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatUnitInfo> checker;
	
	
	public MatCheckUnit(ModelCheckerOption option) {
		checker = new MatUnitCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatInfo> recordInfos) {
		for (MatInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatInfo recordInfo) {
		return checker.check(MatUnitInfo.copyFrom(recordInfo));
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
