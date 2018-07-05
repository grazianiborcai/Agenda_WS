package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckExist;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckMat;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckOwner;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckStore;
import br.com.gda.business.materialStore.model.checker.MatStoreCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciAction;
import br.com.gda.model.decisionTree.DeciChoice;
import br.com.gda.model.decisionTree.DeciResult;
import br.com.gda.model.decisionTree.DeciTree;
import br.com.gda.model.decisionTree.DeciTreeHelper;
import br.com.gda.model.decisionTree.DeciTreeHelperOption;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootMatStoreInsert implements DeciTree<MatStoreInfo> {
	private DeciTree<MatStoreInfo> tree;
	
	
	public RootMatStoreInsert(DeciTreeOption<MatStoreInfo> option) {
		DeciTreeHelperOption<MatStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<MatStoreInfo> buildDecisionChecker(DeciTreeOption<MatStoreInfo> option) {
		final boolean EXIST_ON_DB = true;	
		final boolean DONT_EXIST_ON_DB = false;
		
		List<ModelChecker<MatStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatStoreInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new MatStoreCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatStoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatStoreCheckStore(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new MatStoreCheckMat(checkerOption);
		queue.add(checker);	
		
		//StoreMat
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = DONT_EXIST_ON_DB;		
		checker = new MatStoreCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<DeciAction<MatStoreInfo>> buildActionsOnPassed(DeciTreeOption<MatStoreInfo> option) {
		List<DeciAction<MatStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new NodeMatStoreInsert(option).toAction());	
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<MatStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public DeciAction<MatStoreInfo> toAction() {
		return tree.toAction();
	}
}
