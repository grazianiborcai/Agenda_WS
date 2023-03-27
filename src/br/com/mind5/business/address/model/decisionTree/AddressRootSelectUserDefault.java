package br.com.mind5.business.address.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.business.address.model.action.AddressVisiMergeAddaultUser;
import br.com.mind5.business.address.model.action.AddressVisiRootSelect;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class AddressRootSelectUserDefault extends DeciTreeTemplateWrite<AddressInfo> {
	
	public AddressRootSelectUserDefault(DeciTreeOption<AddressInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AddressInfo> buildCheckerHook(DeciTreeOption<AddressInfo> option) {
		List<ModelChecker<AddressInfo>> queue = new ArrayList<>();		
		ModelChecker<AddressInfo> checker;	

		checker = new ModelCheckerDummy<AddressInfo>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AddressInfo>> buildActionsOnPassedHook(DeciTreeOption<AddressInfo> option) {
		List<ActionStd<AddressInfo>> actions = new ArrayList<>();		
		
		ActionStd <AddressInfo> mergeAddaultUser = new ActionStdCommom <AddressInfo>(option, AddressVisiMergeAddaultUser.class);		
		ActionLazy<AddressInfo> select           = new ActionLazyCommom<AddressInfo>(option, AddressVisiRootSelect.class);
		
		mergeAddaultUser.addPostAction(select);
		
		actions.add(mergeAddaultUser);			
		return actions;
	}
}
