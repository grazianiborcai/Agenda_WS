package br.com.mind5.business.ownerSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.business.ownerSearch.model.action.OwnarchVisiEnforceBusinessOwnerKey;
import br.com.mind5.business.ownerSearch.model.action.OwnarchVisiRootSelect;
import br.com.mind5.business.ownerSearch.model.checker.OwnarchCheckReadBusinessOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class OwnarchRootSelectBusinessOwner extends DeciTreeTemplateRead<OwnarchInfo> {

	public OwnarchRootSelectBusinessOwner(DeciTreeOption<OwnarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnarchInfo> buildCheckerHook(DeciTreeOption<OwnarchInfo> option) {
		List<ModelChecker<OwnarchInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnarchInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnarchCheckReadBusinessOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnarchInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnarchInfo> option) {
		List<ActionStd<OwnarchInfo>> actions = new ArrayList<>();

		ActionStd<OwnarchInfo> enforceBusinessOwnerKey = new ActionStdCommom<OwnarchInfo>(option, OwnarchVisiEnforceBusinessOwnerKey.class);
		ActionLazy<OwnarchInfo> select = new ActionLazyCommom<OwnarchInfo>(option, OwnarchVisiRootSelect.class);
		
		enforceBusinessOwnerKey.addPostAction(select);
		
		actions.add(enforceBusinessOwnerKey);
		return actions;
	}
}
	