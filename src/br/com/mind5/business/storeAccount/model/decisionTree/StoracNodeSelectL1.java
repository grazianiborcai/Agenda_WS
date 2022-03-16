package br.com.mind5.business.storeAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.model.action.StoracVisiEnforceAccountCompleted;
import br.com.mind5.business.storeAccount.model.action.StoracVisiEnforceHasPartner;
import br.com.mind5.business.storeAccount.model.checker.StoracCheckStoparch;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class StoracNodeSelectL1 extends DeciTreeTemplateWrite<StoracInfo> {
	
	public StoracNodeSelectL1(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoracInfo> buildCheckerHook(DeciTreeOption<StoracInfo> option) {
		List<ModelChecker<StoracInfo>> queue = new ArrayList<>();
		ModelChecker<StoracInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoracCheckStoparch(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnPassedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd<StoracInfo> enforceHasPartner = new ActionStdCommom<StoracInfo>(option, StoracVisiEnforceHasPartner.class);
		ActionLazy<StoracInfo> enforceAccountCompleted = new ActionLazyCommom<StoracInfo>(option.conn, option.schemaName, StoracVisiEnforceAccountCompleted.class);
		
		actions.add(enforceHasPartner);
		enforceHasPartner.addPostAction(enforceAccountCompleted);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnFailedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd<StoracInfo> sucess = new ActionStdSuccessCommom<StoracInfo>(option);
		
		actions.add(sucess);
		return actions;
	}
}
