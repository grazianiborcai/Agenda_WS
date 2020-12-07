package br.com.mind5.business.cartItemSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.cartItemSearch.model.action.LazyCartemarchRootSelect;
import br.com.mind5.business.cartItemSearch.model.action.StdCartemarchEnforceUserKey;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootCartemarchSelectUser extends DeciTreeTemplateWrite<CartemarchInfo> {
	
	public RootCartemarchSelectUser(DeciTreeOption<CartemarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemarchInfo> buildCheckerHook(DeciTreeOption<CartemarchInfo> option) {
		List<ModelChecker<CartemarchInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemarchInfo> checker;

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemarchInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemarchInfo> option) {
		List<ActionStd<CartemarchInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemarchInfo> enforceUserKey = new StdCartemarchEnforceUserKey(option);
		ActionLazy<CartemarchInfo> select = new LazyCartemarchRootSelect(option.conn, option.schemaName);
		
		enforceUserKey.addPostAction(select);
		
		actions.add(enforceUserKey);
		return actions;
	}
}
