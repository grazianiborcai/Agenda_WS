package br.com.gda.payService.payPartnerStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;
import br.com.gda.payService.payPartnerStore.model.action.StdPayPartnerStoreSelect;
import br.com.gda.payService.payPartnerStore.model.checker.PayPartnerStoreCheckOwner;
import br.com.gda.payService.payPartnerStore.model.checker.PayPartnerStoreCheckRead;
import br.com.gda.payService.payPartnerStore.model.checker.PayPartnerStoreCheckStore;

public final class RootPayPartnerStoreSelect implements DeciTree<PayPartnerStoreInfo> {
	private DeciTree<PayPartnerStoreInfo> tree;
	
	
	public RootPayPartnerStoreSelect(DeciTreeOption<PayPartnerStoreInfo> option) {
		DeciTreeHelperOption<PayPartnerStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayPartnerStoreInfo> buildDecisionChecker(DeciTreeOption<PayPartnerStoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayPartnerStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayPartnerStoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayPartnerStoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayPartnerStoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayPartnerStoreCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayPartnerStoreInfo>> buildActionsOnPassed(DeciTreeOption<PayPartnerStoreInfo> option) {
		List<ActionStd<PayPartnerStoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdPayPartnerStoreSelect(option));
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayPartnerStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayPartnerStoreInfo> toAction() {
		return tree.toAction();
	}
}
