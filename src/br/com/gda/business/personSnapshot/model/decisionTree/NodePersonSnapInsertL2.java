package br.com.gda.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.action.LazyPersonSnapInsert;
import br.com.gda.business.personSnapshot.model.action.StdPersonSnapMergePerson;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckExist;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckSnap;
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

public final class NodePersonSnapInsertL2 implements DeciTree<PersonSnapInfo> {
	private DeciTree<PersonSnapInfo> tree;
	
	
	public NodePersonSnapInsertL2(DeciTreeOption<PersonSnapInfo> option) {
		DeciTreeHelperOption<PersonSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = null;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonSnapInfo> buildDecisionChecker(DeciTreeOption<PersonSnapInfo> option) {
		final boolean EXIST = true;
		final boolean DONT_EXIST = false;
		
		List<ModelChecker<PersonSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonSnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new PersonSnapCheckSnap(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST;	
		checker = new PersonSnapCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PersonSnapInfo>> buildActionsOnPassed(DeciTreeOption<PersonSnapInfo> option) {
		List<ActionStd<PersonSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PersonSnapInfo> mergePhone = new StdPersonSnapMergePerson(option);	
		ActionLazy<PersonSnapInfo> insert = new LazyPersonSnapInsert(option.conn, option.schemaName);
		
		mergePhone.addPostAction(insert);
		
		actions.add(mergePhone);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PersonSnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PersonSnapInfo> toAction() {
		return tree.toAction();
	}
}
