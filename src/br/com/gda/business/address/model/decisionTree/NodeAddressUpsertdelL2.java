package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressNodeUpsertdelL3;
import br.com.gda.business.address.model.action.LazyAddressRootInsert;
import br.com.gda.business.address.model.action.StdAddressFilterNew;
import br.com.gda.business.address.model.action.StdAddressFilterOld;
import br.com.gda.business.address.model.checker.AddressCheckNewRecord;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeAddressUpsertdelL2 extends DeciTreeWriteTemplate<AddressInfo> {
	
	public NodeAddressUpsertdelL2(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		final boolean ONLY_OLD_RECORD = false;
		
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ONLY_OLD_RECORD;	
		checker = new AddressCheckNewRecord(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> nodeL3 = new NodeAddressUpsertdelL3(option).toAction();
		
		actions.add(nodeL3);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> filterOld = new StdAddressFilterOld(option);			
		ActionLazy<AddressInfo> nodeL3 = new LazyAddressNodeUpsertdelL3(option.conn, option.schemaName);
		ActionStd<AddressInfo> filterNew = new StdAddressFilterNew(option);			
		ActionLazy<AddressInfo> insert = new LazyAddressRootInsert(option.conn, option.schemaName);
		
		//ActionStd<AddressInfo> select = new RootAddressSelect(option).toAction();	//TODO: temp

		
		filterOld.addPostAction(nodeL3);
		filterNew.addPostAction(insert);
		
		//TODO: MERGE resultado
		
		actions.add(filterOld);		
		actions.add(filterNew);	
		//actions.add(select);	
		return actions;
	}
}
