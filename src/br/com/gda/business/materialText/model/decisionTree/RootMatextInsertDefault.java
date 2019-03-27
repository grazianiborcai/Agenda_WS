package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.action.LazyMatextRootInsert;
import br.com.gda.business.materialText.model.action.StdMatextEnforceDefaultOn;
import br.com.gda.business.materialText.model.checker.MatextCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatextInsertDefault implements DeciTree<MatextInfo> {
	private DeciTree<MatextInfo> tree;
	
	
	public RootMatextInsertDefault(DeciTreeOption<MatextInfo> option) {
		DeciTreeHelperOption<MatextInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatextInfo> buildDecisionChecker(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;	
		
		checker = new MatextCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<MatextInfo>> buildActionsOnPassed(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatextInfo> enforceDefaultOn = new StdMatextEnforceDefaultOn(option);	
		ActionLazy<MatextInfo> rootInsert = new LazyMatextRootInsert(option.conn, option.schemaName);
		
		enforceDefaultOn.addPostAction(rootInsert);
		
		actions.add(enforceDefaultOn);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatextInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<MatextInfo> toAction() {
		return tree.toAction();
	}
}
