package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressEnforceDistrictSearch;
import br.com.mind5.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.mind5.business.address.model.action.LazyAddressMergeFormess;
import br.com.mind5.business.address.model.action.LazyAddressMergeUsername;
import br.com.mind5.business.address.model.action.LazyAddressNodeDefaultL1;
import br.com.mind5.business.address.model.action.LazyAddressNodeGeoL1;
import br.com.mind5.business.address.model.action.LazyAddressNodeSnapshot;
import br.com.mind5.business.address.model.action.LazyAddressNodeUpdate;
import br.com.mind5.business.address.model.action.LazyAddressRootSelect;
import br.com.mind5.business.address.model.action.StdAddressMergeToUpdate;
import br.com.mind5.business.address.model.checker.AddressCheckCountry;
import br.com.mind5.business.address.model.checker.AddressCheckExist;
import br.com.mind5.business.address.model.checker.AddressCheckLangu;
import br.com.mind5.business.address.model.checker.AddressCheckOwner;
import br.com.mind5.business.address.model.checker.AddressCheckRefMulti;
import br.com.mind5.business.address.model.checker.AddressCheckRefWrite;
import br.com.mind5.business.address.model.checker.AddressCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootAddressUpdate extends DeciTreeTemplateWrite<AddressInfo> {
	
	public RootAddressUpdate(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	

	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
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
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new AddressCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		

		ActionStd<AddressInfo> mergeToUpdate = new StdAddressMergeToUpdate(option);		
		ActionLazy<AddressInfo> mergeUsername = new LazyAddressMergeUsername(option.conn, option.schemaName);
		ActionLazy<AddressInfo> mergeForm = new LazyAddressMergeFormess(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceDistrictSearch = new LazyAddressEnforceDistrictSearch(option.conn, option.schemaName);
		ActionLazy<AddressInfo> nodeGeo = new LazyAddressNodeGeoL1(option.conn, option.schemaName);
		ActionLazy<AddressInfo> nodeUpdate = new LazyAddressNodeUpdate(option.conn, option.schemaName);
		ActionLazy<AddressInfo> nodeDefault = new LazyAddressNodeDefaultL1(option.conn, option.schemaName);
		ActionLazy<AddressInfo> snapshot = new LazyAddressNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<AddressInfo> select = new LazyAddressRootSelect(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(mergeUsername);
		mergeUsername.addPostAction(mergeForm);
		mergeForm.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceDistrictSearch);
		enforceDistrictSearch.addPostAction(nodeGeo);
		nodeGeo.addPostAction(nodeUpdate);
		nodeUpdate.addPostAction(nodeDefault);
		nodeDefault.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(mergeToUpdate);		
		return actions;
	}
}
