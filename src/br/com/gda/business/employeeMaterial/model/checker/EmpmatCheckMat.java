package br.com.gda.business.employeeMaterial.model.checker;

import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.material.model.checker.MatCheckExist;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class EmpmatCheckMat implements ModelChecker<EmpmatInfo> {
	private final boolean FAILED = false;
	private final boolean SUCCESS = true;
	
	private ModelChecker<MatInfo> checker;
	
	
	public EmpmatCheckMat(ModelCheckerOption option) {
		checker = new MatCheckExist(option);
	}
	
	
	
	@Override public boolean check(List<EmpmatInfo> recordInfos) {
		for (EmpmatInfo eachInfo : recordInfos) {
			if (check(eachInfo) == FAILED)
				return FAILED;
		}
		
		return SUCCESS;
	}

	
	
	@Override public boolean check(EmpmatInfo recordInfo) {
		return checker.check(MatInfo.copyFrom(recordInfo));
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
