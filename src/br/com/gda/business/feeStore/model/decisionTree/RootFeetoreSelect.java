package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.business.feeStore.model.action.StdFeetoreMergeToSelect;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckFeeCateg;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckOwner;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckRead;
import br.com.gda.business.feeStore.model.checker.FeeStoreCheckStore;
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

public final class RootFeetoreSelect implements DeciTree<FeetoreInfo> {
	private DeciTree<FeetoreInfo> tree;
	
	
	public RootFeetoreSelect(DeciTreeOption<FeetoreInfo> option) {
		DeciTreeHelperOption<FeetoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeetoreInfo> buildDecisionChecker(DeciTreeOption<FeetoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FeetoreInfo>> queue = new ArrayList<>();		
		ModelChecker<FeetoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new FeeStoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeeStoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeeStoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new FeeStoreCheckFeeCateg(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<FeetoreInfo>> buildActionsOnPassed(DeciTreeOption<FeetoreInfo> option) {
		List<ActionStd<FeetoreInfo>> actions = new ArrayList<>();
		
		ActionStd<FeetoreInfo> select = new StdFeetoreMergeToSelect(option);
		actions.add(select);
		
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeetoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeetoreInfo> toAction() {
		return tree.toAction();
	}
}
