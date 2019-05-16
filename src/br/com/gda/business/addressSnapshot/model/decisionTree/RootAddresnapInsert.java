package br.com.gda.business.addressSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.business.addressSnapshot.model.action.LazyAddresnapRootSelect;
import br.com.gda.business.addressSnapshot.model.action.StdAddresnapInsert;
import br.com.gda.business.addressSnapshot.model.checker.AddresnapCheckOwner;
import br.com.gda.business.addressSnapshot.model.checker.AddresnapCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddresnapInsert extends DeciTreeWriteTemplate<AddresnapInfo> {
	
	public RootAddresnapInsert(DeciTreeOption<AddresnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddresnapInfo> buildDecisionCheckerHook(DeciTreeOption<AddresnapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<AddresnapInfo>> queue = new ArrayList<>();		
		ModelChecker<AddresnapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new AddresnapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new AddresnapCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddresnapInfo>> buildActionsOnPassedHook(DeciTreeOption<AddresnapInfo> option) {
		List<ActionStd<AddresnapInfo>> actions = new ArrayList<>();	
		
		ActionStd<AddresnapInfo> insert = new StdAddresnapInsert(option);		
		ActionLazy<AddresnapInfo> select = new LazyAddresnapRootSelect(option.conn, option.schemaName);
		
		insert.addPostAction(select);
		
		actions.add(insert);				
		return actions;
	}
}
