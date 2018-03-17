package br.com.gda.employee.model.checker;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.employee.info.EmpWorkTimeInfo;
import br.com.gda.model.checker.ModelCheckerAbstract;

public final class CheckerEmpWorkTimeModelInsert extends ModelCheckerAbstract<EmpWorkTimeInfo> {
	private List<ModelCheckerAbstract<EmpWorkTimeInfo>> stackChecker;
	private ModelCheckerAbstract<EmpWorkTimeInfo> failedChecker;
	
	public CheckerEmpWorkTimeModelInsert() {
		super();	
		buildStackChecker();
	}
	
	
	
	private void buildStackChecker() {
		final boolean DONT_EXIST_ON_DB = false;		
		this.stackChecker = new ArrayList<>();		
		ModelCheckerAbstract<EmpWorkTimeInfo> checker;
		
		checker = new CheckerEmpWorkTimeExistOnDb(DONT_EXIST_ON_DB);
		this.stackChecker.add(checker);
	}
	
	
	
	@Override protected boolean checkHook(EmpWorkTimeInfo recordInfo) {		
		for (ModelCheckerAbstract<EmpWorkTimeInfo> eachChecker : this.stackChecker) {
			boolean resultChecker = eachChecker.check(recordInfo);
			if (resultChecker != eachChecker.getExpectedResult()) {
				failedChecker = eachChecker;
				return RESULT_FAILED;
			}
		}
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {
		return failedChecker.getFailureExplanation();
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return failedChecker.getFailureCode();
	}
}
