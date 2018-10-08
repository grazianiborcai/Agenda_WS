package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckSoftDelete;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckWrite;
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

final class NodeMatEmpInsert implements DeciTree<MatEmpInfo> {
	private DeciTree<MatEmpInfo> tree;
	
	
	public NodeMatEmpInsert(DeciTreeOption<MatEmpInfo> option) {
		DeciTreeHelperOption<MatEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatEmpInfo> buildDecisionChecker(DeciTreeOption<MatEmpInfo> option) {
		final boolean NOT_DELETED = false;	
		
		List<ModelChecker<MatEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<MatEmpInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatEmpCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = NOT_DELETED;		
		checker = new MatEmpCheckSoftDelete(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatEmpInfo>> buildActionsOnPassed(DeciTreeOption<MatEmpInfo> option) {
		List<ActionStd<MatEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatEmpInsert(option));
		actions.add(new ActionMatEmpSelectAll(option));
		return actions;
	}
	
	
	
	private List<ActionStd<MatEmpInfo>> buildActionsOnFailed(DeciTreeOption<MatEmpInfo> option) {
		List<ActionStd<MatEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatEmpUpdate(option));
		actions.add(new ActionMatEmpSelectAll(option));
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
	
	
	
	@Override public ActionStd<MatEmpInfo> toAction() {
		return tree.toAction();
	}
}
