package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonUpdate;
import br.com.gda.business.person.model.action.StdPersonEnforceLChanged;
import br.com.gda.business.person.model.checker.PersonCheckEntityCateg;
import br.com.gda.business.person.model.checker.PersonCheckExist;
import br.com.gda.business.person.model.checker.PersonCheckGender;
import br.com.gda.business.person.model.checker.PersonCheckKey;
import br.com.gda.business.person.model.checker.PersonCheckOwner;
import br.com.gda.business.person.model.checker.PersonCheckWrite;
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

public final class RootPersonUpdate implements DeciTree<PersonInfo> {
	private DeciTree<PersonInfo> tree;
	
	
	public RootPersonUpdate(DeciTreeOption<PersonInfo> option) {
		DeciTreeHelperOption<PersonInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonInfo> buildDecisionChecker(DeciTreeOption<PersonInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean KEY_NOT_NULL = true;		
		
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PersonCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.expectedResult = KEY_NOT_NULL;
		checker = new PersonCheckKey(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckGender(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckEntityCateg(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckExist(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonInfo>> buildActionsOnPassed(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeL1 = new NodePersonUpdateL1(option).toAction();	
		ActionStd<PersonInfo> nodeL2 = new NodePersonUpdateL2(option).toAction();	
		ActionStd<PersonInfo> enforceLChanged = new StdPersonEnforceLChanged(option);
		ActionLazy<PersonInfo> update = new LazyPersonUpdate(option.conn, option.schemaName);
		
		enforceLChanged.addPostAction(update);
		
		actions.add(nodeL1);	
		actions.add(nodeL2);
		actions.add(enforceLChanged);
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
