package br.com.gda.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.gda.business.address.model.action.LazyAddressMergeForm;
import br.com.gda.business.address.model.action.LazyAddressNodeUpdate;
import br.com.gda.business.address.model.action.StdAddressMergeToUpdate;
import br.com.gda.business.address.model.checker.AddressCheckCountry;
import br.com.gda.business.address.model.checker.AddressCheckExist;
import br.com.gda.business.address.model.checker.AddressCheckLangu;
import br.com.gda.business.address.model.checker.AddressCheckOwner;
import br.com.gda.business.address.model.checker.AddressCheckRefMulti;
import br.com.gda.business.address.model.checker.AddressCheckRefWrite;
import br.com.gda.business.address.model.checker.AddressCheckUpdate;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class RootAddressUpdate extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressUpdate(DeciTreeOption<AddressInfo> option) {
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
		checker = new AddressCheckUpdate(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckRefWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckRefMulti(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckOwner(checkerOption);
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
		checker = new AddressCheckCountry(checkerOption);
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

		ActionStd<AddressInfo> mergeToUpdate = new StdAddressMergeToUpdate(option);		
		ActionLazy<AddressInfo> mergeForm = new LazyAddressMergeForm(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> nodeUpdate = new LazyAddressNodeUpdate(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(mergeForm);
		mergeForm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(nodeUpdate);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
