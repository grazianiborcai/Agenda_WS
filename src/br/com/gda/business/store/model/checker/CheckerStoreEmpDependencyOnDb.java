package br.com.gda.business.store.model.checker;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpExistOnDb;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;

public final class CheckerStoreEmpDependencyOnDb implements ModelChecker<StoreEmpInfo> {
	private final boolean RESULT_SUCCESS = true;
	private final boolean RESULT_FAILED = false;
	private final boolean EXIST_ON_DB = true;
	
	private ModelCheckerOption option;
	private ModelChecker<StoreInfo> checkerStoreExistOnDb;
	private ModelChecker<EmpInfo> checkerEmployeeExistOnDb;
	
	
	public CheckerStoreEmpDependencyOnDb(ModelCheckerOption option) {
		this.option = enforceOption(option);
		
		buildCheckerStore();
		buildCheckerEmployee();
	}
	
	
	
	private ModelCheckerOption enforceOption(ModelCheckerOption option) {
		option.expectedResult = EXIST_ON_DB;
		return option;
	}
	
	
	
	private void buildCheckerStore() {
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = option.expectedResult;		
		checkerStoreExistOnDb = new CheckerStoreExistOnDb(checkerOption);
	}
	
	
	
	private void buildCheckerEmployee() {
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = option.expectedResult;		
		checkerEmployeeExistOnDb = new CheckerEmpExistOnDb(checkerOption);
	}

	
	
	@Override public boolean check(List<StoreEmpInfo> recordInfos) {
		if (recordInfos == null)
			throw new NullPointerException("recordInfos " + SystemMessage.NULL_ARGUMENT);
		
		if (recordInfos.isEmpty())
			throw new NullPointerException("recordInfos " + SystemMessage.EMPTY_ARGUMENT);
		
		
		for (StoreEmpInfo eachRecordInfo : recordInfos) {
			boolean checkerResult = check(eachRecordInfo);
			
			if (checkerResult == RESULT_FAILED)
				return checkerResult;
		}
		
		return RESULT_SUCCESS;
	}
	
	
	
	@Override public boolean check(StoreEmpInfo recordInfo) {
		if (checkStore(recordInfo) == RESULT_FAILED)
			return RESULT_FAILED;
		
		if (checkEmployee(recordInfo) == RESULT_FAILED)
			return RESULT_FAILED;
		
		return RESULT_SUCCESS;
	}
	
	
	
	private boolean checkStore(StoreEmpInfo recordInfo) {
		StoreInfo storeInfo = new StoreInfo();
		storeInfo.codOwner = recordInfo.codOwner;
		storeInfo.codStore = recordInfo.codStore;
		
		return checkerStoreExistOnDb.check(storeInfo);
	}
	
	
	
	private boolean checkEmployee(StoreEmpInfo recordInfo) {
		EmpInfo empInfo = new EmpInfo();
		empInfo.codOwner = recordInfo.codOwner;
		empInfo.codEmployee = recordInfo.codEmployee;
		
		return checkerEmployeeExistOnDb.check(empInfo);
	}
	

	
	@Override public boolean getResult() {
		if (checkerStoreExistOnDb.getResult() == RESULT_FAILED)
			return RESULT_FAILED;
		
		if (checkerEmployeeExistOnDb.getResult() == RESULT_FAILED)
			return RESULT_FAILED;
		
		return RESULT_SUCCESS;
	}

	
	
	@Override public String getFailureExplanation() {
		if (checkerStoreExistOnDb.getResult() == RESULT_FAILED)
			return checkerStoreExistOnDb.getFailureExplanation();
		
		if (checkerEmployeeExistOnDb.getResult() == RESULT_FAILED)
			return checkerEmployeeExistOnDb.getFailureExplanation();
		
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}

	
	
	@Override public int getFailureCode() {
		if (checkerStoreExistOnDb.getResult() == RESULT_FAILED)
			return checkerStoreExistOnDb.getFailureCode();
		
		if (checkerEmployeeExistOnDb.getResult() == RESULT_FAILED)
			return checkerEmployeeExistOnDb.getFailureCode();
		
		throw new IllegalStateException(SystemMessage.NO_ERROR_FOUND);
	}
}
