package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonUpdate;
import br.com.gda.business.person.model.action.StdPersonInsertPersonap;
import br.com.gda.business.person.model.checker.PersonCheckRead;
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

public final class NodePersonSnapshot implements DeciTree<PersonInfo> {
	private DeciTree<PersonInfo> tree;
	
	
	public NodePersonSnapshot(DeciTreeOption<PersonInfo> option) {
		DeciTreeHelperOption<PersonInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonInfo> buildDecisionChecker(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		
		checker = new PersonCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonInfo>> buildActionsOnPassed(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> insertPersonap = new StdPersonInsertPersonap(option);		
		ActionLazy<PersonInfo> update = new LazyPersonUpdate(option.conn, option.schemaName);	
		
		insertPersonap.addPostAction(update);
		
		actions.add(insertPersonap);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PersonInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
}
