package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressDaoUpdate;
import br.com.mind5.business.address.model.action.LazyAddressEnforceDefaultOff;
import br.com.mind5.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.mind5.business.address.model.action.LazyAddressMergeToSelect;
import br.com.mind5.business.address.model.action.LazyAddressMergeUsername;
import br.com.mind5.business.address.model.action.StdAddressMergeAddault;
import br.com.mind5.business.address.model.action.StdAddressSuccess;
import br.com.mind5.business.address.model.checker.AddressCheckAddault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class NodeAddressDefaultL2 extends DeciTreeTemplateWrite<AddressInfo> {
	
	public NodeAddressDefaultL2(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckAddault(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();
		
		ActionStd<AddressInfo> mergeAddault = new StdAddressMergeAddault(option);
		ActionLazy<AddressInfo> mergeToSelect = new LazyAddressMergeToSelect(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> enforceLChangedBy = new LazyAddressMergeUsername(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceDefaultOff = new LazyAddressEnforceDefaultOff(option.conn, option.schemaName);
		ActionLazy<AddressInfo> update = new LazyAddressDaoUpdate(option.conn, option.schemaName);
		ActionStd<AddressInfo> success = new StdAddressSuccess(option);	
		
		mergeAddault.addPostAction(mergeToSelect);
		mergeToSelect.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceDefaultOff);
		enforceDefaultOff.addPostAction(update);
		
		actions.add(mergeAddault);
		actions.add(success);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnFailedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();

		ActionStd<AddressInfo> success = new StdAddressSuccess(option);		
		actions.add(success);
		
		return actions;
	}
}
