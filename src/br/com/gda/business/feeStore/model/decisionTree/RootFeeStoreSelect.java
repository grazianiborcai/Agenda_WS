package br.com.gda.business.feeStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.business.feeStore.model.action.StdFeeStoreSelect;
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

public final class RootFeeStoreSelect implements DeciTree<FeeStoreInfo> {
	private DeciTree<FeeStoreInfo> tree;
	
	
	public RootFeeStoreSelect(DeciTreeOption<FeeStoreInfo> option) {
		DeciTreeHelperOption<FeeStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<FeeStoreInfo> buildDecisionChecker(DeciTreeOption<FeeStoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<FeeStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<FeeStoreInfo> checker;
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
	
	
	
	private List<ActionStd<FeeStoreInfo>> buildActionsOnPassed(DeciTreeOption<FeeStoreInfo> option) {
		List<ActionStd<FeeStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdFeeStoreSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<FeeStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<FeeStoreInfo> toAction() {
		return tree.toAction();
	}
}
