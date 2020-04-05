package br.com.mind5.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.addressSnapshot.info.AddresnapInfo;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapInsert;
import br.com.mind5.business.addressSnapshot.model.action.LazyAddresnapRootSelect;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckAddress;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckOwner;
import br.com.mind5.business.addressSnapshot.model.checker.AddresnapCheckWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddresnapInsert extends DeciTreeWriteTemplate<AddresnapInfo> {
	
	public RootAddresnapInsert(DeciTreeOption<AddresnapInfo> option) {
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
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStdV1<AddresnapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<AddresnapInfo> nodeUser = new NodeAddresnapUselis(option).toAction();	
		ActionLazyV1<AddresnapInfo> insert = new LazyAddresnapInsert(option.conn, option.schemaName);		
		ActionLazyV1<AddresnapInfo> select = new LazyAddresnapRootSelect(option.conn, option.schemaName);
		
		nodeUser.addPostAction(insert);
		insert.addPostAction(select);
		
		actions.add(nodeUser);				
		return actions;
	}
}
