package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressNodeSnapshot;
import br.com.gda.business.address.model.action.StdAddressInsert;
import br.com.gda.business.address.model.checker.AddressCheckWriteA00;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeAddressInsertA00 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressInsertA00(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckWriteA00(checkerOption);
		queue.add(checker);
		
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();
		
		ActionStd<AddressInfo> insert = new StdAddressInsert(option);	
		ActionLazy<AddressInfo> snapshot = new LazyAddressNodeSnapshot(option.conn, option.schemaName);

		insert.addPostAction(snapshot);
		
		actions.add(insert);		
		return actions;
	}
}
