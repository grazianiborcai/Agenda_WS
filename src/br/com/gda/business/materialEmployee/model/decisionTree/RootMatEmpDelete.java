package br.com.gda.business.materialEmployee.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.business.materialEmployee.model.chekcer.MatEmpCheckExist;
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

public final class RootMatEmpDelete implements DeciTree<MatEmpInfo> {
	private DeciTree<MatEmpInfo> tree;
	
	
	public RootMatEmpDelete(DeciTreeOption<MatEmpInfo> option) {
		DeciTreeHelperOption<MatEmpInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatEmpInfo> buildDecisionChecker(DeciTreeOption<MatEmpInfo> option) {
		List<ModelChecker<MatEmpInfo>> queue = new ArrayList<>();		
		ModelChecker<MatEmpInfo> checker;
		
		checker = new MatEmpCheckWrite();
		queue.add(checker);
		
		final boolean EXIST_ON_DB = true;	
		ModelCheckerOption checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;
		
		checker = new MatEmpCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerQueue<MatEmpInfo>(queue);
	}
	
	
	
	private List<ActionStd<MatEmpInfo>> buildActionsOnPassed(DeciTreeOption<MatEmpInfo> option) {
		List<ActionStd<MatEmpInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionMatEmpDelete(option));
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
