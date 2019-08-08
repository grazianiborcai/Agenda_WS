package br.com.gda.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
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
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.model.action.LazyUserapRootSelect;
import br.com.gda.security.userSnapshot.model.action.StdUserapInsert;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckOwner;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckUser;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckWrite;

public final class RootUserapInsert implements DeciTree<UserapInfo> {
	private DeciTree<UserapInfo> tree;
	
	
	public RootUserapInsert(DeciTreeOption<UserapInfo> option) {
		DeciTreeHelperOption<UserapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<UserapInfo> buildDecisionChecker(DeciTreeOption<UserapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<UserapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new UserapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserapCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<UserapInfo>> buildActionsOnPassed(DeciTreeOption<UserapInfo> option) {
		List<ActionStd<UserapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserapInfo> insert = new StdUserapInsert(option);
		ActionLazy<UserapInfo> select = new LazyUserapRootSelect(option.conn, option.schemaName);
		
		insert.addPostAction(select);
		
		actions.add(insert);	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<UserapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<UserapInfo> toAction() {
		return tree.toAction();
	}
}
