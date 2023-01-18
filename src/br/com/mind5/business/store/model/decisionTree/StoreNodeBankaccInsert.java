package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiBankaccInsert;
import br.com.mind5.business.store.model.action.StoreVisiEnforceBankaccKey;
import br.com.mind5.business.store.model.checker.StoreCheckHasBankacc;
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

public final class StoreNodeBankaccInsert extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreNodeBankaccInsert(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasBankacc(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforceBankaccKey = new ActionStdCommom<StoreInfo>(option, StoreVisiEnforceBankaccKey.class);
		ActionLazy<StoreInfo> insertBankacc = new  ActionLazyCommom<StoreInfo>(option, StoreVisiBankaccInsert.class);	
		
		enforceBankaccKey.addPostAction(insertBankacc);
		
		actions.add(enforceBankaccKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> sucess = new ActionStdSuccessCommom<StoreInfo>(option);		
		
		actions.add(sucess);		
		return actions;
	}
}
