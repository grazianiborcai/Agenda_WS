package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckEmp;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckExist;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckMat;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckOwner;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckStore;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckStoreEmp;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckWrite;
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

public final class RootMatEmpInsert implements DeciTree<MatEmpInfo> {
	private DeciTree<MatEmpInfo> tree;
	
	
	public RootMatEmpInsert(DeciTreeOption<MatEmpInfo> option) {
		DeciTreeHelperOption<MatEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatEmpInfo> buildDecisionChecker(DeciTreeOption<MatEmpInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<MatEmpInfo>> stack = new ArrayList<>();		
		ModelChecker<MatEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatEmpCheckWrite();
		stack.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckOwner(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckStore(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckEmp(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckMat(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckStoreEmp(checkerOption);
		stack.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new MatEmpCheckExist(checkerOption);
		stack.add(checker);	
		
		return new ModelCheckerStack<>(stack);
	}
	
	
	
	private List<DeciAction<MatEmpInfo>> buildActionsOnPassed(DeciTreeOption<MatEmpInfo> option) {
		List<DeciAction<MatEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionNodeInsert(option));	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatEmpInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	

	
	
	
	private static class ActionNodeInsert implements DeciAction<MatEmpInfo> {
		DeciTree<MatEmpInfo> treeHelper;
		
		
		public ActionNodeInsert(DeciTreeOption<MatEmpInfo> option) {
			treeHelper = new NodeMatEmpInsert(option);
		}
		
		
		
		@Override public boolean executeAction() {			
			  treeHelper.makeDecision();
			  DeciResult<MatEmpInfo> treeResult = treeHelper.getDecisionResult();
			  return treeResult.hasSuccessfullyFinished();
		}
		
		
		
		@Override public DeciResult<MatEmpInfo> getDecisionResult() {
			return treeHelper.getDecisionResult();
		}
	}
}
