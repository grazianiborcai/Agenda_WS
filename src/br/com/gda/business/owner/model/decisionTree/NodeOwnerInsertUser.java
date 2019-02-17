package br.com.gda.business.owner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.owner.model.action.LazyOwnerEnforceUserCateg;
import br.com.gda.business.owner.model.action.LazyOwnerInsertUser;
import br.com.gda.business.owner.model.action.StdOwnerEnforceAuthGroup;
import br.com.gda.business.owner.model.checker.OwnerCheckDummy;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeOwnerInsertUser implements DeciTree<OwnerInfo> {
	private DeciTree<OwnerInfo> tree;
	
	
	public NodeOwnerInsertUser(DeciTreeOption<OwnerInfo> option) {
		DeciTreeHelperOption<OwnerInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<OwnerInfo> buildDecisionChecker(DeciTreeOption<OwnerInfo> option) {
		List<ModelChecker<OwnerInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnerInfo> checker;	
		
		checker = new OwnerCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<OwnerInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<OwnerInfo>> buildActionsOnPassed(DeciTreeOption<OwnerInfo> option) {
		List<ActionStd<OwnerInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnerInfo> enforceAuthGroup = new StdOwnerEnforceAuthGroup(option);
		ActionLazy<OwnerInfo> enforceUserCateg = new LazyOwnerEnforceUserCateg(option.conn, option.schemaName);
		ActionLazy<OwnerInfo> insertUser = new LazyOwnerInsertUser(option.conn, option.schemaName);
		
		enforceAuthGroup.addPostAction(enforceUserCateg);	
		enforceUserCateg.addPostAction(insertUser);	
		
		actions.add(enforceAuthGroup);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<OwnerInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
