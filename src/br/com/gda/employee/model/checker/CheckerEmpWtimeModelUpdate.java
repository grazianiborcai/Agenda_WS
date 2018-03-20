package br.com.gda.employee.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStackAbstract;

public class CheckerEmpWtimeModelUpdate extends ModelCheckerStackAbstract<EmpWtimeInfo> {
	public CheckerEmpWtimeModelUpdate() {
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
