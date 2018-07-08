package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckExist;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatEmpSelect implements DeciTree<MatEmpInfo> {
	private DeciTree<MatEmpInfo> tree;
	
	
	public RootMatEmpSelect(DeciTreeOption<MatEmpInfo> option) {
		DeciTreeHelperOption<MatEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatEmpInfo> buildDecisionChecker(DeciTreeOption<MatEmpInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<MatEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<MatEmpInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checker = new MatEmpCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatEmpCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<MatEmpInfo>> buildActionsOnPassed(DeciTreeOption<MatEmpInfo> option) {
		List<DeciAction<MatEmpInfo>> actions = new ArrayList<>();
		
		DeciAction<MatEmpInfo> starter = new ActionMatEmpSelect(option);
		HandlerMatEmpMergeMat mergeMaterial = new HandlerMatEmpMergeMat(option.conn, option.schemaName);
		HandlerMatEmpMergeEmp mergeEmployee = new HandlerMatEmpMergeEmp(option.conn, option.schemaName);		
		
		actions.add(starter);
		starter.addPostAction(mergeMaterial);
		mergeMaterial.addPostAction(mergeEmployee);
		
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
	
	
	
	@Override public DeciAction<MatEmpInfo> toAction() {
		return tree.toAction();
	}
}
