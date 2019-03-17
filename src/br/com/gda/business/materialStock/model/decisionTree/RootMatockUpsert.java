package br.com.gda.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.checker.MatockCheckExist;
import br.com.gda.business.materialStock.model.checker.MatockCheckWrite;
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

public final class RootMatockUpsert implements DeciTree<MatockInfo> {
	private DeciTree<MatockInfo> tree;
	
	
	public RootMatockUpsert(DeciTreeOption<MatockInfo> option) {
		DeciTreeHelperOption<MatockInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.schemaName = option.schemaName;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatockInfo> buildDecisionChecker(DeciTreeOption<MatockInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatockCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatockCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatockInfo>> buildActionsOnPassed(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();	
		ActionStd<MatockInfo> update = new RootMatockUpdate(option).toAction();	

		actions.add(update);
		return actions;
	}
	
	
	
	private List<ActionStd<MatockInfo>> buildActionsOnFailed(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();	
		ActionStd<MatockInfo> insert = new RootMatockInsert(option).toAction();	

		actions.add(insert);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatockInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatockInfo> toAction() {
		return tree.toAction();
	}
}
