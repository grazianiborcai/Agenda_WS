package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiNodeAddressUpsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeCompUpdate;
import br.com.mind5.business.store.model.action.StoreVisiNodePersonUpdate;
import br.com.mind5.business.store.model.action.StoreVisiNodePhoneUpsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeStorextUpsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeStowotmUpsertdel;
import br.com.mind5.business.store.model.action.StoreVisiNodeStuntmUpsertdel;
import br.com.mind5.business.store.model.checker.StoreCheckCurrency;
import br.com.mind5.business.store.model.checker.StoreCheckExist;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckOwner;
import br.com.mind5.business.store.model.checker.StoreCheckStorauth;
import br.com.mind5.business.store.model.checker.StoreCheckTimezone;
import br.com.mind5.business.store.model.checker.StoreCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreRootUpdate extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreRootUpdate(DeciTreeOption<StoreInfo> option) {
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

		ActionStd<StoreInfo> updateStore = new StoreNodeUpdate(option).toAction();
		ActionLazy<StoreInfo> upsertStorext = new  ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStorextUpsert.class);
		ActionLazy<StoreInfo> updatePerson = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodePersonUpdate.class);
		ActionLazy<StoreInfo> updateCompany = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeCompUpdate.class);
		ActionLazy<StoreInfo> upsertAddress = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeAddressUpsert.class);
		ActionLazy<StoreInfo> upsertPhone = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodePhoneUpsert.class);
		ActionLazy<StoreInfo> upsertdelStowotm = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStowotmUpsertdel.class);
		ActionLazy<StoreInfo> upsertdelStuntm = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStuntmUpsertdel.class);
		ActionStd<StoreInfo> select = new StoreRootSelect(option).toAction();	
			
		updateStore.addPostAction(upsertStorext);
		updateStore.addPostAction(updatePerson);
		updateStore.addPostAction(updateCompany);		
		updateStore.addPostAction(upsertAddress);		
		updateStore.addPostAction(upsertPhone);
		updateStore.addPostAction(upsertdelStowotm);
		updateStore.addPostAction(upsertdelStuntm);
		
		actions.add(updateStore);
		actions.add(select);
		return actions;
	}
}
