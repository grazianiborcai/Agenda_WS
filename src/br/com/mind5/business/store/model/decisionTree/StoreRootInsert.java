package br.com.mind5.business.store.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.business.store.model.action.StoreVisiNodeInsertComp;
import br.com.mind5.business.store.model.action.StoreVisiNodeInsertPerson;
import br.com.mind5.business.store.model.action.StoreVisiNodeInsertPhone;
import br.com.mind5.business.store.model.action.StoreVisiNodeInsertStorext;
import br.com.mind5.business.store.model.action.StoreVisiNodeSnapshot;
import br.com.mind5.business.store.model.action.StoreVisiNodeUpsertAddress;
import br.com.mind5.business.store.model.action.StoreVisiRootSelect;
import br.com.mind5.business.store.model.action.StoreVisiMatbcinInsert;
import br.com.mind5.business.store.model.action.StoreVisiUserInsert;
import br.com.mind5.business.store.model.checker.StoreCheckCurrency;
import br.com.mind5.business.store.model.checker.StoreCheckHasAddress;
import br.com.mind5.business.store.model.checker.StoreCheckLangu;
import br.com.mind5.business.store.model.checker.StoreCheckOwner;
import br.com.mind5.business.store.model.checker.StoreCheckTimezone;
import br.com.mind5.business.store.model.checker.StoreCheckWrite;
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
		checker = new StoreCheckWrite(checkerOption);
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StoreCheckCurrency(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StoreInfo> option) {
		List<ActionStd<StoreInfo>> actions = new ArrayList<>();
		//TODO: permitir que outro usuario seja associado ou inves de sempre criar um novo ?
		//TODO: O que fazer se o CPF/e-mail ja tiver associado a um customer/owner/store manager ?
		ActionStd<StoreInfo> insertStore = new StoreNodeInsert(option).toAction();
		ActionLazy<StoreInfo> insertPerson = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeInsertPerson.class);	
		ActionLazy<StoreInfo> insertComp = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeInsertComp.class);
		ActionLazy<StoreInfo> insertUser = new ActionLazyCommom<StoreInfo>(option, StoreVisiUserInsert.class);
		ActionLazy<StoreInfo> snapshot = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeSnapshot.class);
		ActionLazy<StoreInfo> upsertAddress = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeUpsertAddress.class);		
		ActionLazy<StoreInfo> insertPhone = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeInsertPhone.class);
		ActionLazy<StoreInfo> insertStorext = new ActionLazyCommom<StoreInfo>(option, StoreVisiNodeInsertStorext.class);			
		ActionLazy<StoreInfo> matbcinInsert = new ActionLazyCommom<StoreInfo>(option, StoreVisiMatbcinInsert.class);		
		ActionLazy<StoreInfo> selectStore = new ActionLazyCommom<StoreInfo>(option, StoreVisiRootSelect.class);	
		
		insertStore.addPostAction(insertPerson);		
		insertPerson.addPostAction(insertComp);		
		insertComp.addPostAction(insertUser);
		insertUser.addPostAction(snapshot);
		snapshot.addPostAction(upsertAddress);			
		snapshot.addPostAction(insertPhone);
		snapshot.addPostAction(insertStorext);
		snapshot.addPostAction(matbcinInsert);
		snapshot.addPostAction(selectStore);
		
		actions.add(insertStore);	
		return actions;
	}
}
