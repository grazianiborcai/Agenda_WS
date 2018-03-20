package br.com.gda.employee.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStackAbstract;

public final class CheckerEmpWtimeModelDelete extends ModelCheckerStackAbstract<EmpWtimeInfo> {

	public CheckerEmpWtimeModelDelete() {
		super();
	}
	
	
	
	@Override protected List<ModelCheckerAbstract<EmpWtimeInfo>> buildStackCheckerHook() {
		List<ModelCheckerAbstract<EmpWtimeInfo>> resultStackChecker = new ArrayList<>();		
		ModelCheckerAbstract<EmpWtimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryWrite();
		resultStackChecker.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		checker = new CheckerEmpWtimeExistOnDb(EXIST_ON_DB);
		resultStackChecker.add(checker);		
		
		return resultStackChecker;
	}
}
