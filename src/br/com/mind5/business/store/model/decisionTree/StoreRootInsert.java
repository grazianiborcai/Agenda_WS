package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiMatbcinInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeAddressUpsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeBankaccInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeCompInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodePeregInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodePhoneInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeSnapshot;
import br.com.mind5.business.store.model.action.StoreVisiNodeStorextInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeStowotmInsert;
import br.com.mind5.business.store.model.action.StoreVisiNodeStuntmInsert;
import br.com.mind5.business.store.model.action.StoreVisiRootSelect;
import br.com.mind5.business.store.model.action.StoreVisiStoparCreate;
import br.com.mind5.business.store.model.action.StoreVisiUserInsert;
import br.com.mind5.business.store.model.checker.StoreCheckCurrency;
import br.com.mind5.business.store.model.checker.StoreCheckHasAddress;
import br.com.mind5.business.store.model.checker.StoreCheckInsert;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckOwner;
import br.com.mind5.business.store.model.checker.StoreCheckTimezone;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoreRootInsert extends DeciTreeTemplateWrite<StoreInfo> {
	
	public StoreRootInsert(DeciTreeOption<StoreInfo> option) {
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
		checker = new StoreCheckInsert(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StoreCheckHasAddress(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		// Fixar BRL ou criticar
		checker = new StoreCheckCurrency(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		//TODO: permitir que outro usuario seja associado ou inves de sempre criar um novo ?
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStd<StoreInfo> insertStore = new StoreNodeInsert(option).toAction();
		ActionLazy<StoreInfo> insertComp = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeCompInsert.class);
		ActionLazy<StoreInfo> insertPereg = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodePeregInsert.class);
		ActionLazy<StoreInfo> insertUser = new ActionLazyCommom<StoreInfo>(option, StoreVisiUserInsert.class);
		ActionLazy<StoreInfo> insertBankacc = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeBankaccInsert.class);
		ActionLazy<StoreInfo> snapshot = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeSnapshot.class);
		ActionLazy<StoreInfo> upsertAddress = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeAddressUpsert.class);		
		ActionLazy<StoreInfo> insertPhone = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodePhoneInsert.class);
		ActionLazy<StoreInfo> insertStorext = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStorextInsert.class);			
		ActionLazy<StoreInfo> insertMatbcin = new ActionLazyCommom<StoreInfo>(option, StoreVisiMatbcinInsert.class);
		ActionLazy<StoreInfo> insertStowotm = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStowotmInsert.class);
		ActionLazy<StoreInfo> insertStuntm = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeStuntmInsert.class);		
		ActionLazy<StoreInfo> createStopar = new ActionLazyCommom<StoreInfo>(option, StoreVisiStoparCreate.class);
		ActionLazy<StoreInfo> selectStore = new ActionLazyCommom<StoreInfo>(option, StoreVisiRootSelect.class);	
		
		insertStore.addPostAction(insertComp);
		insertComp.addPostAction(insertPereg);		
		insertPereg.addPostAction(insertUser);		
		insertUser.addPostAction(insertBankacc);
		insertBankacc.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);			
		snapshot.addPostAction(insertPhone);
		snapshot.addPostAction(insertStorext);
		snapshot.addPostAction(insertMatbcin);
		snapshot.addPostAction(insertStowotm);
		snapshot.addPostAction(insertStuntm);
		snapshot.addPostAction(createStopar);
		createStopar.addPostAction(selectStore);
		
		actions.add(insertStore);	
		return actions;
	}
}
