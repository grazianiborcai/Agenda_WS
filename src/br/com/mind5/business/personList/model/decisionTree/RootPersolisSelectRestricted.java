package br.com.mind5.business.personList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personList.model.action.LazyPersolisEnforceRestricted;
import br.com.mind5.business.personList.model.checker.PersolisCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersolisSelectRestricted extends DeciTreeReadTemplate<PersolisInfo> {
	
	public RootPersolisSelectRestricted(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersolisInfo> buildDecisionCheckerHook(DeciTreeOption<PersolisInfo> option) {
		List<ModelChecker<PersolisInfo>> queue = new ArrayList<>();		
		ModelChecker<PersolisInfo> checker;

		checker = new PersolisCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersolisInfo>> buildActionsOnPassedHook(DeciTreeOption<PersolisInfo> option) {
		List<ActionStd<PersolisInfo>> actions = new ArrayList<>();
		
		ActionStd<PersolisInfo> select = new RootPersolisSelect(option).toAction();		
		ActionLazy<PersolisInfo> enforceRestricted = new LazyPersolisEnforceRestricted(option.conn, option.schemaName);	
		
		select.addPostAction(enforceRestricted);		
		
		actions.add(select);		
		return actions;
	}
}
