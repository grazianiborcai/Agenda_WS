package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreUpsertPhone;
import br.com.mind5.business.store.model.action.StdStoreEnforcePhoneKey;
import br.com.mind5.business.store.model.action.StdStoreSuccess;
import br.com.mind5.business.store.model.checker.StoreCheckHasPhone;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeStoreUpsertPhone extends DeciTreeWriteTemplate<StoreInfo> {
	
	public NodeStoreUpsertPhone(DeciTreeOption<StoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoreInfo> buildDecisionCheckerHook(DeciTreeOption<StoreInfo> option) {
		List<ModelChecker<StoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StoreInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasPhone(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		ActionStd<StoreInfo> enforcePhoneKey = new StdStoreEnforcePhoneKey(option);
		ActionLazy<StoreInfo> upsertPhone = new LazyStoreUpsertPhone(option.conn, option.schemaName);	
		
		enforcePhoneKey.addPostAction(upsertPhone);
		
		actions.add(enforcePhoneKey);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		
		actions.add(new StdStoreSuccess(option));		
		return actions;
	}
}
