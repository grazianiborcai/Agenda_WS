package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressEnforceCreatedBy;
import br.com.mind5.business.address.model.action.LazyAddressEnforceCreatedOn;
import br.com.mind5.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.mind5.business.address.model.action.LazyAddressMergeUsername;
import br.com.mind5.business.address.model.action.LazyAddressNodeInsert;
import br.com.mind5.business.address.model.action.StdAddressMergeForm;
import br.com.mind5.business.address.model.checker.AddressCheckCountry;
import br.com.mind5.business.address.model.checker.AddressCheckInsert;
import br.com.mind5.business.address.model.checker.AddressCheckLangu;
import br.com.mind5.business.address.model.checker.AddressCheckLimit;
import br.com.mind5.business.address.model.checker.AddressCheckOwner;
import br.com.mind5.business.address.model.checker.AddressCheckRefMulti;
import br.com.mind5.business.address.model.checker.AddressCheckRefWrite;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootAddressInsert extends DeciTreeWriteTemplate<AddressInfo> {
	
	public RootAddressInsert(DeciTreeOption<AddressInfo> option) {
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
		checker = new AddressCheckInsert(checkerOption);
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
		checker = new AddressCheckLangu(checkerOption);
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
		checker = new AddressCheckCountry(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new AddressCheckLimit(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV1<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<AddressInfo> mergeForm = new StdAddressMergeForm(option);		
		ActionLazyV1<AddressInfo> mergeUsername = new LazyAddressMergeUsername(option.conn, option.schemaName);
		ActionLazyV1<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);
		ActionLazyV1<AddressInfo> enforceCreatedOn = new LazyAddressEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazyV1<AddressInfo> enforceCreatedBy = new LazyAddressEnforceCreatedBy(option.conn, option.schemaName);	
		ActionLazyV1<AddressInfo> nodeInsert = new LazyAddressNodeInsert(option.conn, option.schemaName);	
		
		mergeForm.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(nodeInsert);
		
		actions.add(mergeForm);		
		return actions;
	}
}
