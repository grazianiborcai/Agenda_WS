package br.com.gda.business.snapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.business.snapshot.model.action.LazySnapInsert;
import br.com.gda.business.snapshot.model.action.StdSnapEnforceLChanged;
import br.com.gda.business.snapshot.model.checker.SnapCheckOwner;
import br.com.gda.business.snapshot.model.checker.SnapCheckWrite;
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

public final class RootSnapInsert implements DeciTree<SnapInfo> {
	private DeciTree<SnapInfo> tree;
	
	
	public RootSnapInsert(DeciTreeOption<SnapInfo> option) {
		DeciTreeHelperOption<SnapInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<SnapInfo> buildDecisionChecker(DeciTreeOption<SnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<SnapInfo>> queue = new ArrayList<>();		
		ModelChecker<SnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new SnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new SnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<SnapInfo>> buildActionsOnPassed(DeciTreeOption<SnapInfo> option) {
		List<ActionStd<SnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<SnapInfo> enforceLChanged = new StdSnapEnforceLChanged(option);
		ActionLazy<SnapInfo> insert = new LazySnapInsert(option.conn, option.schemaName);	
		
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceLChanged);		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<SnapInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<SnapInfo> toAction() {
		return tree.toAction();
	}
}
