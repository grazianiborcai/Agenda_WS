package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.AddressVisiMergeAddarchStore;
import br.com.mind5.business.address.model.action.AddressVisiRootUpdate;
import br.com.mind5.business.address.model.checker.AddressCheckExistStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddressNodeStoreUpsert extends DeciTreeTemplateWrite<AddressInfo> {
	
	public AddressNodeStoreUpsert(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckExistStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd <AddressInfo> mergeAddarchStore = new ActionStdCommom <AddressInfo>(option, AddressVisiMergeAddarchStore.class);		
		ActionLazy<AddressInfo> update            = new ActionLazyCommom<AddressInfo>(option, AddressVisiRootUpdate.class);
		
		mergeAddarchStore.addPostAction(update);
		
		actions.add(mergeAddarchStore);		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddressInfo> insert = new AddressRootInsert(option).toAction();
		
		actions.add(insert);		
		return actions;
	}
}
