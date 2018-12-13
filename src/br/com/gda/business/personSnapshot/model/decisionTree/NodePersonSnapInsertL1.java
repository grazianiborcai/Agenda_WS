package br.com.gda.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.business.personSnapshot.model.action.LazyPersonSnapNodeInsertL2;
import br.com.gda.business.personSnapshot.model.action.StdPersonSnapMergeSnap;
import br.com.gda.business.personSnapshot.model.checker.PersonSnapCheckHasSnap;
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

public final class NodePersonSnapInsertL1 implements DeciTree<PersonSnapInfo> {
	private DeciTree<PersonSnapInfo> tree;
	
	
	public NodePersonSnapInsertL1(DeciTreeOption<PersonSnapInfo> option) {
		DeciTreeHelperOption<PersonSnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.actionsOnFailed = buildActionsOnFailed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PersonSnapInfo> buildDecisionChecker(DeciTreeOption<PersonSnapInfo> option) {
		List<ModelChecker<PersonSnapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonSnapInfo> checker;	
		
		checker = new PersonSnapCheckHasSnap();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PersonSnapInfo>> buildActionsOnPassed(DeciTreeOption<PersonSnapInfo> option) {
		List<ActionStd<PersonSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PersonSnapInfo> nodeL2 = new NodePersonSnapInsertL2(option).toAction();	
		
		actions.add(nodeL2);
		return actions;
	}
	
	
	
	private List<ActionStd<PersonSnapInfo>> buildActionsOnFailed(DeciTreeOption<PersonSnapInfo> option) {
		List<ActionStd<PersonSnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<PersonSnapInfo> mergeSnap = new StdPersonSnapMergeSnap(option);	
		ActionLazy<PersonSnapInfo> nodeL2 = new LazyPersonSnapNodeInsertL2(option.conn, option.schemaName);
		
		mergeSnap.addPostAction(nodeL2);
		
		actions.add(mergeSnap);
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
