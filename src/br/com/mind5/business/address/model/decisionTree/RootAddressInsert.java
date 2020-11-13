package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.LazyAddressEnforceCreatedBy;
import br.com.mind5.business.address.model.action.LazyAddressEnforceCreatedOn;
import br.com.mind5.business.address.model.action.LazyAddressEnforceDistrictSearch;
import br.com.mind5.business.address.model.action.LazyAddressEnforceLChanged;
import br.com.mind5.business.address.model.action.LazyAddressMergeUsername;
import br.com.mind5.business.address.model.action.LazyAddressNodeDefaultL1;
import br.com.mind5.business.address.model.action.LazyAddressNodeGeoL1;
import br.com.mind5.business.address.model.action.LazyAddressNodeInsert;
import br.com.mind5.business.address.model.action.LazyAddressNodeSnapshot;
import br.com.mind5.business.address.model.action.LazyAddressRootSelect;
import br.com.mind5.business.address.model.action.StdAddressMergeFormess;
import br.com.mind5.business.address.model.checker.AddressCheckCountry;
import br.com.mind5.business.address.model.checker.AddressCheckInsert;
import br.com.mind5.business.address.model.checker.AddressCheckLangu;
import br.com.mind5.business.address.model.checker.AddressCheckLimit;
import br.com.mind5.business.address.model.checker.AddressCheckOwner;
import br.com.mind5.business.address.model.checker.AddressCheckRefMulti;
import br.com.mind5.business.address.model.checker.AddressCheckRefWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootAddressInsert extends DeciTreeTemplateWriteV2<AddressInfo> {
	
	public RootAddressInsert(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelCheckerV1<AddressInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<AddressInfo> checker;	
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStdV2<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStdV2<AddressInfo> mergeForm = new StdAddressMergeFormess(option);		
		ActionLazy<AddressInfo> mergeUsername = new LazyAddressMergeUsername(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceLChanged = new LazyAddressEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceCreatedOn = new LazyAddressEnforceCreatedOn(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> enforceCreatedBy = new LazyAddressEnforceCreatedBy(option.conn, option.schemaName);
		ActionLazy<AddressInfo> enforceDistrictSearch = new LazyAddressEnforceDistrictSearch(option.conn, option.schemaName);
		ActionLazy<AddressInfo> nodeGeo = new LazyAddressNodeGeoL1(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> nodeInsert = new LazyAddressNodeInsert(option.conn, option.schemaName);	
		ActionLazy<AddressInfo> nodeDefault = new LazyAddressNodeDefaultL1(option.conn, option.schemaName);
		ActionLazy<AddressInfo> snapshot = new LazyAddressNodeSnapshot(option.conn, option.schemaName);
		ActionLazy<AddressInfo> select = new LazyAddressRootSelect(option.conn, option.schemaName);
		
		mergeForm.addPostAction(mergeUsername);
		mergeUsername.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(enforceDistrictSearch);
		enforceDistrictSearch.addPostAction(nodeGeo);
		nodeGeo.addPostAction(nodeInsert);
		nodeInsert.addPostAction(nodeDefault);
		nodeDefault.addPostAction(snapshot);
		snapshot.addPostAction(select);
		
		actions.add(mergeForm);		
		return actions;
	}
}
