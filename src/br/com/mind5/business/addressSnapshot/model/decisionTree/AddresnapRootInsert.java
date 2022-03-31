package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiRootSelect;
import br.com.mind5.business.addressSnapshot.model.action.AddresnapVisiDaoInsert;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckAddress;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckOwner;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddresnapRootInsert extends DeciTreeTemplateWrite<AddresnapInfo> {
	
	public AddresnapRootInsert(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddresnapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddresnapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddresnapCheckAddress(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddresnapInfo> nodeUser = new AddresnapNodeUselis(option).toAction();	
		ActionLazy<AddresnapInfo> insert = new ActionLazyCommom<AddresnapInfo>(option, AddresnapVisiDaoInsert.class);		
		ActionLazy<AddresnapInfo> select = new ActionLazyCommom<AddresnapInfo>(option, AddresnapVisiRootSelect.class);
		
		nodeUser.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeUser);				
		return actions;
	}
}
