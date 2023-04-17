package br.com.mind5.webhook.pagarmeHook.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiEnforceCreatedOn;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiEnforceIdPayment;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiEnforceIsRefreshedOff;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiEnforceLastChanged;
import br.com.mind5.webhook.pagarmeHook.model.action.PagookVisiNodeInsertL1;
import br.com.mind5.webhook.pagarmeHook.model.checker.PagookCheckInsert;

public final class PagookRootInsert extends DeciTreeTemplateWrite<PagookInfo> {
	
	public PagookRootInsert(DeciTreeOption<PagookInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PagookInfo> buildCheckerHook(DeciTreeOption<PagookInfo> option) {	
		List<ModelChecker<PagookInfo>> queue = new ArrayList<>();		
		ModelChecker<PagookInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PagookCheckInsert(checkerOption);
		queue.add(checker);

		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PagookInfo>> buildActionsOnPassedHook(DeciTreeOption<PagookInfo> option) {
		List<ActionStd<PagookInfo>> actions = new ArrayList<>();	
		
		ActionStd <PagookInfo> enforceIdPayment      = new ActionStdCommom<PagookInfo> (option, PagookVisiEnforceIdPayment.class);
		ActionLazy<PagookInfo> enforceCreatedOn      = new ActionLazyCommom<PagookInfo>(option, PagookVisiEnforceCreatedOn.class);
		ActionLazy<PagookInfo> enforceLastChanged    = new ActionLazyCommom<PagookInfo>(option, PagookVisiEnforceLastChanged.class);
		ActionLazy<PagookInfo> enforceIsRefreshedOff = new ActionLazyCommom<PagookInfo>(option, PagookVisiEnforceIsRefreshedOff.class);
		ActionLazy<PagookInfo> nodeL1                = new ActionLazyCommom<PagookInfo>(option, PagookVisiNodeInsertL1.class);
		
		enforceIdPayment.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceLastChanged);
		enforceLastChanged.addPostAction(enforceIsRefreshedOff);
		enforceIsRefreshedOff.addPostAction(nodeL1);
		
		actions.add(enforceIdPayment);
		
		return actions;
	}
}
