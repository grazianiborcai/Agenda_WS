package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.AddressVisiDaoUpdate;
import br.com.mind5.business.address.model.action.AddressVisiEnforceDefaultOff;
import br.com.mind5.business.address.model.action.AddressVisiEnforceLChanged;
import br.com.mind5.business.address.model.action.AddressVisiMergeAddault;
import br.com.mind5.business.address.model.action.AddressVisiMergeToSelect;
import br.com.mind5.business.address.model.action.AddressVisiMergeUsername;
import br.com.mind5.business.address.model.checker.AddressCheckAddault;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.action.commom.ActionStdSuccessCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddressNodeDefaultL2 extends DeciTreeTemplateWrite<AddressInfo> {
	
	public AddressNodeDefaultL2(DeciTreeOption<AddressInfo> option) {
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
		
		ActionStd <AddressInfo> mergeAddault      = new ActionStdCommom <AddressInfo>(option, AddressVisiMergeAddault.class);
		ActionLazy<AddressInfo> mergeToSelect     = new ActionLazyCommom<AddressInfo>(option, AddressVisiMergeToSelect.class);
		ActionLazy<AddressInfo> enforceLChanged   = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceLChanged.class);	
		ActionLazy<AddressInfo> enforceLChangedBy = new ActionLazyCommom<AddressInfo>(option, AddressVisiMergeUsername.class);
		ActionLazy<AddressInfo> enforceDefaultOff = new ActionLazyCommom<AddressInfo>(option, AddressVisiEnforceDefaultOff.class);
		ActionLazy<AddressInfo> update            = new ActionLazyCommom<AddressInfo>(option, AddressVisiDaoUpdate.class);
		ActionStd <AddressInfo> success           = new ActionStdSuccessCommom<AddressInfo>(option);	
		
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

		ActionStd<AddressInfo> success = new ActionStdSuccessCommom<AddressInfo>(option);		
		actions.add(success);
		
		return actions;
	}
}
