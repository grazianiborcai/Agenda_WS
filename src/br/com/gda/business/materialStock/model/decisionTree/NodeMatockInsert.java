package br.com.gda.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.action.StdMatockInsert;
import br.com.gda.business.materialStock.model.checker.MatockCheckLimit;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeMatockInsert implements DeciTree<MatockInfo> {
	private DeciTree<MatockInfo> tree;
	
	
	public NodeMatockInsert(DeciTreeOption<MatockInfo> option) {
		DeciTreeHelperOption<MatockInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatockInfo> buildDecisionChecker(DeciTreeOption<MatockInfo> option) {
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		
		checker = new MatockCheckLimit();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatockInfo>> buildActionsOnPassed(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();

		ActionStd<MatockInfo> insert = new StdMatockInsert(option);
		ActionStd<MatockInfo> select = new RootMatockSelect(option).toAction();	
		
		actions.add(insert);	
		actions.add(select);
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
