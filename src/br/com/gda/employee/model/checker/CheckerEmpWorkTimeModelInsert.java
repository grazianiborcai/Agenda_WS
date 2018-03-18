package br.com.gda.employee.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStackAbstract;

public final class CheckerEmpWorkTimeModelInsert extends ModelCheckerStackAbstract<EmpWorkTimeInfo> {
	public CheckerEmpWorkTimeModelInsert() {
		super();	
	}
	
	
	
	@Override protected List<ModelCheckerAbstract<EmpWorkTimeInfo>> buildStackCheckerHook() {
		List<ModelCheckerAbstract<EmpWorkTimeInfo>> resultStackChecker = new ArrayList<>();		
		ModelCheckerAbstract<EmpWorkTimeInfo> checker;
		
		final boolean DONT_EXIST_ON_DB = false;	
		checker = new CheckerEmpWorkTimeExistOnDb(DONT_EXIST_ON_DB);
		resultStackChecker.add(checker);
		
		return resultStackChecker;
	}
}
