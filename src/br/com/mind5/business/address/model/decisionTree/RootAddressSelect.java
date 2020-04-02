package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressMergeCountry;
import br.com.mind5.business.address.model.action.LazyAddressMergeForm;
import br.com.mind5.business.address.model.action.LazyAddressNodeState;
import br.com.mind5.business.address.model.action.StdAddressMergeToSelect;
import br.com.mind5.business.address.model.checker.AddressCheckLangu;
import br.com.mind5.business.address.model.checker.AddressCheckOwner;
import br.com.mind5.business.address.model.checker.AddressCheckRead;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

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
	
	
	
	@Override protected List<ActionStdV1<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV1<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStdV1<AddressInfo> select = new StdAddressMergeToSelect(option);		
		ActionLazyV1<AddressInfo> mergeForm = new LazyAddressMergeForm(option.conn, option.schemaName);
		ActionLazyV1<AddressInfo> mergeCountry = new LazyAddressMergeCountry(option.conn, option.schemaName);
		ActionLazyV1<AddressInfo> nodeState = new LazyAddressNodeState(option.conn, option.schemaName);
		
		select.addPostAction(mergeForm);	
		mergeForm.addPostAction(mergeCountry);
		mergeCountry.addPostAction(nodeState);
		
		actions.add(select);			
		return actions;
	}
}
