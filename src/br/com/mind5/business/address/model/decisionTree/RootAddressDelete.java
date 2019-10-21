package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressDelete;
import br.com.mind5.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.mind5.business.address.model.action.LazyAddressUpdate;
import br.com.mind5.business.address.model.action.StdAddressMergeToDelete;
import br.com.mind5.business.address.model.checker.AddressCheckDelete;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddressDelete extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressDelete(DeciTreeOption<AddressInfo> option) {
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
		checker = new AddressCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd<AddressInfo> mergeToDelete = new StdAddressMergeToDelete(option);	
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<AddressInfo> update = new LazyAddressUpdate(option.conn, option.schemaName);
		ActionLazy<AddressInfo> delete = new LazyAddressDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(update);
		update.addPostAction(delete);
		
		actions.add(mergeToDelete);		
		
		return actions;
	}
}
