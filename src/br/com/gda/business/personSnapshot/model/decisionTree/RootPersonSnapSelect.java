package br.com.gda.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.action.LazyPersonSnapMergeGender;
import br.com.gda.business.personSnapshot.model.action.StdPersonSnapSelect;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckRead;
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

public final class RootPersonSnapSelect implements DeciTree<PersonSnapInfo> {
	private DeciTree<PersonSnapInfo> tree;
	
	
	public RootPersonSnapSelect(DeciTreeOption<PersonSnapInfo> option) {
		DeciTreeHelperOption<PersonSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker();
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonSnapInfo> buildDecisionChecker() {
		List<ModelChecker<PersonSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonSnapInfo> checker;
		
		checker = new PersonSnapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override public ActionStd<PersonSnapInfo> toAction() {
		return tree.toAction();
	}
	
	
	
	private List<ActionStd<PersonSnapInfo>> buildActionsOnPassed(DeciTreeOption<PersonSnapInfo> option) {
		List<ActionStd<PersonSnapInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonSnapInfo> select = new StdPersonSnapSelect(option);		
		ActionLazy<PersonSnapInfo> mergeGender = new LazyPersonSnapMergeGender(option.conn, option.schemaName);
		
		select.addPostAction(mergeGender);		
		actions.add(select);
		
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
