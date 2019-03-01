package br.com.gda.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.person.model.action.LazyPersonDelete;
import br.com.gda.business.person.model.action.LazyPersonEnforceLChanged;
import br.com.gda.business.person.model.action.LazyPersonMergeUsername;
import br.com.gda.business.person.model.action.LazyPersonUpdate;
import br.com.gda.business.person.model.action.StdPersonMergeToDelete;
import br.com.gda.business.person.model.checker.PersonCheckDelete;
import br.com.gda.business.person.model.checker.PersonCheckExist;
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

public final class RootPersonDelete implements DeciTree<PersonInfo> {
	private DeciTree<PersonInfo> tree;
	
	
	public RootPersonDelete(DeciTreeOption<PersonInfo> option) {
		DeciTreeHelperOption<PersonInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonInfo> buildDecisionChecker(DeciTreeOption<PersonInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PersonCheckDelete();
		queue.add(checker);
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerQueue<PersonInfo>(queue);
	}
	
	
	
	@Override public ActionStd<PersonInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonInfo>> buildActionsOnPassed(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> mergeToDelete = new StdPersonMergeToDelete(option);	
		ActionLazy<PersonInfo> enforceLChanged = new LazyPersonEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> updatePerson = new LazyPersonUpdate(option.conn, option.schemaName);
		ActionLazy<PersonInfo> deletePerson = new LazyPersonDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updatePerson);
		updatePerson.addPostAction(deletePerson);
		
		actions.add(mergeToDelete);
		
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
