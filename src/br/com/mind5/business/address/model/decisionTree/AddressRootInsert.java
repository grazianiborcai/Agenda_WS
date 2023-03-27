package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.AddressVisiEnforceCreatedBy;
import br.com.mind5.business.address.model.action.AddressVisiEnforceCreatedOn;
import br.com.mind5.business.address.model.action.AddressVisiEnforceDistrictSearch;
import br.com.mind5.business.address.model.action.AddressVisiEnforceLChanged;
import br.com.mind5.business.address.model.action.AddressVisiMergeFormess;
import br.com.mind5.business.address.model.action.AddressVisiMergeUsername;
import br.com.mind5.business.address.model.action.AddressVisiNodeDefaultL1;
import br.com.mind5.business.address.model.action.AddressVisiNodeGeoL1;
import br.com.mind5.business.address.model.action.AddressVisiNodeInsert;
import br.com.mind5.business.address.model.action.AddressVisiNodeSnapshot;
import br.com.mind5.business.address.model.action.AddressVisiRootSelect;
import br.com.mind5.business.address.model.checker.AddressCheckCountry;
import br.com.mind5.business.address.model.checker.AddressCheckInsert;
import br.com.mind5.business.address.model.checker.AddressCheckLangu;
import br.com.mind5.business.address.model.checker.AddressCheckLimit;
import br.com.mind5.business.address.model.checker.AddressCheckOwner;
import br.com.mind5.business.address.model.checker.AddressCheckRefMulti;
import br.com.mind5.business.address.model.checker.AddressCheckRefWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddressRootInsert extends DeciTreeTemplateWrite<AddressInfo> {
	
	public AddressRootInsert(DeciTreeOption<AddressInfo> option) {
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
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();	
		
		ActionStd <AddressInfo> nodeSafeString        = new AddressNodeSafeString(option).toAction();
		ActionStd <AddressInfo> mergeForm             = new ActionStdCommom<AddressInfo>(option, AddressVisiMergeFormess.class);		
		ActionLazy<AddressInfo> mergeUsername         = new ActionLazyCommom<AddressInfo>(option, AddressVisiMergeUsername.class);
		ActionLazy<AddressInfo> enforceLChanged       = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceLChanged.class);
		ActionLazy<AddressInfo> enforceCreatedOn      = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceCreatedOn.class);	
		ActionLazy<AddressInfo> enforceCreatedBy      = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceCreatedBy.class);
		ActionLazy<AddressInfo> enforceDistrictSearch = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceDistrictSearch.class);
		ActionLazy<AddressInfo> nodeGeo               = new ActionLazyCommom<AddressInfo>(option, AddressVisiNodeGeoL1.class);	
		ActionLazy<AddressInfo> nodeInsert            = new ActionLazyCommom<AddressInfo>(option, AddressVisiNodeInsert.class);	
		ActionLazy<AddressInfo> nodeDefault           = new ActionLazyCommom<AddressInfo>(option, AddressVisiNodeDefaultL1.class);
		ActionLazy<AddressInfo> snapshot              = new ActionLazyCommom<AddressInfo>(option, AddressVisiNodeSnapshot.class);
		ActionLazy<AddressInfo> select                = new ActionLazyCommom<AddressInfo>(option, AddressVisiRootSelect.class);
		
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
		
		actions.add(nodeSafeString);
		actions.add(mergeForm);
		
		return actions;
	}
}
