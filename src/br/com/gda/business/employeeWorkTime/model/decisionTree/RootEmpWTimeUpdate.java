package br.com.gda.business.employeeWorkTime.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckEmp;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckExist;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckEWTC;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckKey;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckOwner;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckStore;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckSE;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckSWT;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckWeekday;
import br.com.gda.business.employeeWorkTime.model.checker.EmpWTimeCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootEmpWTimeUpdate implements DeciTree<EmpWTimeInfo> {
	private DeciTree<EmpWTimeInfo> tree;
	
	
	public RootEmpWTimeUpdate(DeciTreeOption<EmpWTimeInfo> option) {
		DeciTreeHelperOption<EmpWTimeInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpWTimeInfo> buildDecisionChecker(DeciTreeOption<EmpWTimeInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<EmpWTimeInfo>> queue = new ArrayList<>();		
		ModelChecker<EmpWTimeInfo> checker;			
		ModelCheckerOption checkerOption;
		
		checker = new EmpWTimeCheckWrite();
		queue.add(checker);
		
		checker = new EmpWTimeCheckKey();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckEmp(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckWeekday(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckSE(checkerOption);
		queue.add(checker);			
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new EmpWTimeCheckSWT(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new EmpWTimeCheckEWTC(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<EmpWTimeInfo>> buildActionsOnPassed(DeciTreeOption<EmpWTimeInfo> option) {
		List<ActionStd<EmpWTimeInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionEmpWTimeUpdate(option));
		actions.add(new ActionEmpWTimeSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpWTimeInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<EmpWTimeInfo> toAction() {
		return tree.toAction();
	}
}
