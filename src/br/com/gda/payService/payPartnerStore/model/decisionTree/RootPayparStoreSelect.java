package br.com.gda.payService.payPartnerStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

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
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;
import br.com.gda.payService.payPartnerStore.model.action.LazyPayparStoreMergePaypar;
import br.com.gda.payService.payPartnerStore.model.action.StdPayparStoreSelect;
import br.com.gda.payService.payPartnerStore.model.checker.PayparStoreCheckOwner;
import br.com.gda.payService.payPartnerStore.model.checker.PayparStoreCheckRead;
import br.com.gda.payService.payPartnerStore.model.checker.PayparStoreCheckStore;

public final class RootPayparStoreSelect implements DeciTree<PayparStoreInfo> {
	private DeciTree<PayparStoreInfo> tree;
	
	
	public RootPayparStoreSelect(DeciTreeOption<PayparStoreInfo> option) {
		DeciTreeHelperOption<PayparStoreInfo> helperOption = new DeciTreeHelperOption<>();
		
		helperOption.visitorChecker = buildDecisionChecker(option);
		helperOption.recordInfos = option.recordInfos;
		helperOption.conn = option.conn;
		helperOption.actionsOnPassed = buildActionsOnPassed(option);
		
		tree = new DeciTreeHelper<>(helperOption);
	}
	
	
	
	private ModelChecker<PayparStoreInfo> buildDecisionChecker(DeciTreeOption<PayparStoreInfo> option) {
		final boolean EXIST_ON_DB = true;
		
		List<ModelChecker<PayparStoreInfo>> queue = new ArrayList<>();		
		ModelChecker<PayparStoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checker = new PayparStoreCheckRead();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayparStoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PayparStoreCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	private List<ActionStd<PayparStoreInfo>> buildActionsOnPassed(DeciTreeOption<PayparStoreInfo> option) {
		List<ActionStd<PayparStoreInfo>> actions = new ArrayList<>();
		
		ActionStd<PayparStoreInfo> select = new StdPayparStoreSelect(option);
		ActionLazy<PayparStoreInfo> mergePayPartner = new LazyPayparStoreMergePaypar(option.conn, option.schemaName);
		
		select.addPostAction(mergePayPartner);
		
		actions.add(select);
		return actions;
	}
	
	
	
	@Override public void makeDecision() {
		tree.makeDecision();
	}
		

	
	@Override public DeciChoice getDecisionMade() {
		return tree.getDecisionMade();
	}
	
	
	
	@Override public DeciResult<PayparStoreInfo> getDecisionResult() {
		return tree.getDecisionResult();
	}
	
	
	
	@Override public ActionStd<PayparStoreInfo> toAction() {
		return tree.toAction();
	}
}
