package br.com.gda.employee.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWtimeInfo;
import br.com.gda.model.checker.ModelCheckerAbstract;
import br.com.gda.model.checker.ModelCheckerStackAbstract;

public final class CheckerEmpWtimeModelSelect extends ModelCheckerStackAbstract<EmpWtimeInfo> {
	
	public CheckerEmpWtimeModelSelect() {
		super();
	}
	
	
	
	@Override protected List<ModelCheckerAbstract<EmpWtimeInfo>> buildStackCheckerHook() {
		List<ModelCheckerAbstract<EmpWtimeInfo>> resultStackChecker = new ArrayList<>();		
		ModelCheckerAbstract<EmpWtimeInfo> checker;
		
		checker = new CheckerEmpWtimeMandatoryRead();
		resultStackChecker.add(checker);
		
		return resultStackChecker;
	}
}
