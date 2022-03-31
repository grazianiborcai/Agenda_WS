package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.StoriteVisiDaoInsert;
import br.com.mind5.business.storeFavorite.model.action.StoriteVisiEnforceCreatedOn;
import br.com.mind5.business.storeFavorite.model.action.StoriteVisiEnforceLChanged;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckExist;
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

public final class StoriteNodeInsert extends DeciTreeTemplateWrite<StoriteInfo> {
	
	public StoriteNodeInsert(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelChecker<StoriteInfo>> queue = new ArrayList<>();		
		ModelChecker<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckExist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStd<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStd<StoriteInfo> success = new ActionStdSuccessCommom<StoriteInfo>(option);
		
		actions.add(success);	
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StoriteInfo>> buildActionsOnFailedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStd<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStd<StoriteInfo> enforceCreatedOn = new ActionStdCommom<StoriteInfo>(option, StoriteVisiEnforceCreatedOn.class);
		ActionLazy<StoriteInfo> enforceLChanged = new ActionLazyCommom<StoriteInfo>(option, StoriteVisiEnforceLChanged.class);
		ActionLazy<StoriteInfo> insert = new ActionLazyCommom<StoriteInfo>(option, StoriteVisiDaoInsert.class);
		
		enforceCreatedOn.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(insert);
		
		actions.add(enforceCreatedOn);	
		return actions;
	}
}
