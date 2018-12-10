package br.com.gda.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.action.StdPersonSnapInsert;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckOwner;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckPerson;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckSnapHdr;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckWrite;
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

public final class RootPersonSnapInsert implements DeciTree<PersonSnapInfo> {
	private DeciTree<PersonSnapInfo> tree;
	
	
	public RootPersonSnapInsert(DeciTreeOption<PersonSnapInfo> option) {
		DeciTreeHelperOption<PersonSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonSnapInfo> buildDecisionChecker(DeciTreeOption<PersonSnapInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<PersonSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonSnapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PersonSnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonSnapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonSnapCheckSnapHdr(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonSnapCheckPerson(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonSnapInfo>> buildActionsOnPassed(DeciTreeOption<PersonSnapInfo> option) {
		List<ActionStd<PersonSnapInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonSnapInfo> insert = new StdPersonSnapInsert(option);	
		actions.add(insert);
		
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
}
