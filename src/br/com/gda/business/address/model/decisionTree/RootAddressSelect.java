package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressMergeCountry;
import br.com.gda.business.address.model.action.LazyAddressMergeForm;
import br.com.gda.business.address.model.action.LazyAddressNodeState;
import br.com.gda.business.address.model.action.StdAddressMergeToSelect;
import br.com.gda.business.address.model.checker.AddressCheckLangu;
import br.com.gda.business.address.model.checker.AddressCheckOwner;
import br.com.gda.business.address.model.checker.AddressCheckRead;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddressSelect extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressSelect(DeciTreeOption<AddressInfo> option) {
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
		checker = new AddressCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> select = new StdAddressMergeToSelect(option);		
		ActionLazy<AddressInfo> mergeForm = new LazyAddressMergeForm(option.conn, option.schemaName);
		ActionLazy<AddressInfo> mergeCountry = new LazyAddressMergeCountry(option.conn, option.schemaName);
		ActionLazy<AddressInfo> nodeState = new LazyAddressNodeState(option.conn, option.schemaName);
		
		select.addPostAction(mergeForm);	
		mergeForm.addPostAction(mergeCountry);
		mergeCountry.addPostAction(nodeState);
		
		actions.add(select);			
		return actions;
	}
}
