package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressRootDelete;
import br.com.gda.business.address.model.action.StdAddressFilterDeleted;
import br.com.gda.business.address.model.checker.AddressCheckFlagDel;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeAddressUpsertdelL3 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressUpsertdelL3(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		final boolean ONLY_NON_DELETED_RECORD = false;
		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ONLY_NON_DELETED_RECORD;	
		checker = new AddressCheckFlagDel(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> update = new RootAddressUpdate(option).toAction();
		
		actions.add(update);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> update = new RootAddressUpdate(option).toAction();
		ActionStd<AddressInfo> filterDel = new StdAddressFilterDeleted(option);			
		ActionLazy<AddressInfo> delete = new LazyAddressRootDelete(option.conn, option.schemaName);
		
		filterDel.addPostAction(delete);
		
		//TODO: MERGE resultado
		
		actions.add(update);		
		actions.add(filterDel);	
		
		return actions;
	}
}
