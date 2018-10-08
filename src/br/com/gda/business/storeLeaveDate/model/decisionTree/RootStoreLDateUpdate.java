package br.com.gda.business.storeLeaveDate.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckExist;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckOwner;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckStore;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckTimeRange;
import br.com.gda.business.storeLeaveDate.model.checker.StoreLDateCheckWrite;
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

public final class RootStoreLDateUpdate implements DeciTree<StoreLDateInfo> {
	private DeciTree<StoreLDateInfo> tree;
	
	
	public RootStoreLDateUpdate(DeciTreeOption<StoreLDateInfo> option) {
		DeciTreeHelperOption<StoreLDateInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		helperOption.conn = option.conn;
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<StoreLDateInfo> buildDecisionChecker(DeciTreeOption<StoreLDateInfo> option) {
		List<ModelChecker<StoreLDateInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreLDateInfo> checker;
		ModelCheckerOption checkerOption;
		final boolean EXIST_ON_DB = true;
		
		checker = new StoreLDateCheckWrite();
		queue.add(checker);
		
		checker = new StoreLDateCheckTimeRange();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreLDateCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreLDateCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new StoreLDateCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<StoreLDateInfo>> buildActionsOnPassed(DeciTreeOption<StoreLDateInfo> option) {
		List<ActionStd<StoreLDateInfo>> actions = new ArrayList<>();
		
		actions.add(new ActionStoreLDateUpdate(option));
		actions.add(new ActionStoreLDateSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<StoreLDateInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<StoreLDateInfo> toAction() {
		return tree.toAction();
	}
}
