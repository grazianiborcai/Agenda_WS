package br.com.gda.business.employee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employee.model.checker.CheckerEmpCpf;
import br.com.gda.business.employee.model.checker.CheckerEmpExistOnDb;
import br.com.gda.business.employee.model.checker.CheckerEmpMandatoryKey;
import br.com.gda.business.employee.model.checker.CheckerEmpMandatoryWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerStack;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class EmpRootUpdate implements DeciTree<EmpInfo> {
	private DeciTree<EmpInfo> tree;
	
	
	public EmpRootUpdate(DeciTreeOption<EmpInfo> option) {
		DeciTreeHelperOption<EmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<EmpInfo> buildDecisionChecker(DeciTreeOption<EmpInfo> option) {
		final boolean EXIST_ON_DB = true;			
		final boolean KEY_NOT_NULL = true;	
		
		List<ModelChecker<EmpInfo>> stack = new ArrayList<>();		
		ModelChecker<EmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new CheckerEmpMandatoryWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new CheckerEmpMandatoryKey(checkerOption);
		stack.add(checker);
		
		checker = new CheckerEmpCpf();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new CheckerEmpExistOnDb(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<EmpInfo>> buildActionsOnPassed(DeciTreeOption<EmpInfo> option) {
		List<DeciAction<EmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionNodeUpdate(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<EmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	
	
	
	private static class ActionNodeUpdate implements DeciAction<EmpInfo> {
		DeciTree<EmpInfo> treeHelper;
		
		
		public ActionNodeUpdate(DeciTreeOption<EmpInfo> option) {
			treeHelper = new EmpNodeUpdateL1(option);
		}
		
		
		
		@Override public boolean executeAction() {			
			  treeHelper.makeDecision();
			  DeciResult<EmpInfo> treeResult = treeHelper.getDecisionResult();
			  return treeResult.hasSuccessfullyFinished();
		}
		
		
		
		@Override public DeciResult<EmpInfo> getDecisionResult() {
			return treeHelper.getDecisionResult();
		}
	}
}
