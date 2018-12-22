package br.com.gda.business.materialSnapshot.model.checker;

import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.checker.SnapCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class MatSnapCheckSnap implements ModelChecker<MatSnapInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<SnapInfo> checker;
	
	
	public MatSnapCheckSnap(ModelCheckerOption option) {
		checker = new SnapCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<MatSnapInfo> recordInfos) {
		for (MatSnapInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(MatSnapInfo recordInfo) {
		return checker.check(SnapInfo.copyFrom(recordInfo));
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
