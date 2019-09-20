package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressRootSelect;
import br.com.gda.business.address.model.action.StdAddressMergeAddarch;
import br.com.gda.business.address.model.checker.AddressCheckDummy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddressSearch extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressSearch(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildDecisionCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	

		checker = new AddressCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> mergeAddarch = new StdAddressMergeAddarch(option);		
		ActionLazy<AddressInfo> select = new LazyAddressRootSelect(option.conn, option.schemaName);
		
		mergeAddarch.addPostAction(select);
		
		actions.add(mergeAddarch);			
		return actions;
	}
}
