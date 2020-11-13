package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpdateComp;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpdatePerson;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpsertAddress;
import br.com.mind5.business.store.model.action.LazyStoreNodeUpsertPhone;
import br.com.mind5.business.store.model.checker.StoreCheckCurrency;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckOwner;
import br.com.mind5.business.store.model.checker.StoreCheckStorauth;
import br.com.mind5.business.store.model.checker.StoreCheckTimezone;
import br.com.mind5.business.store.model.checker.StoreCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootStoreUpdate extends DeciTreeTemplateWrite<StoreInfo> {
	
	public RootStoreUpdate(DeciTreeOption<StoreInfo> option) {
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
		checker = new StoreCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckLangu(checkerOption);
		queue.add(checker);		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckTimezone(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckCurrency(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckExist(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckStorauth(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();

		ActionStd<StoreInfo> updateStore = new NodeStoreUpdate(option).toAction();
		ActionLazy<StoreInfo> updatePerson = new LazyStoreNodeUpdatePerson(option.conn, option.schemaName);
		ActionLazy<StoreInfo> updateCompany = new LazyStoreNodeUpdateComp(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertAddress = new LazyStoreNodeUpsertAddress(option.conn, option.schemaName);
		ActionLazy<StoreInfo> upsertPhone = new LazyStoreNodeUpsertPhone(option.conn, option.schemaName);		
		ActionStd<StoreInfo> select = new RootStoreSelect(option).toAction();	
			
		updateStore.addPostAction(updatePerson);
		updateStore.addPostAction(updateCompany);		
		updateStore.addPostAction(upsertAddress);		
		updateStore.addPostAction(upsertPhone);
		
		actions.add(updateStore);
		actions.add(select);
		return actions;
	}
}
