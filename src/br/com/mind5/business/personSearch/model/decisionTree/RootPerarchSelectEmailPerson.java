package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchRootSelectAuth;
import br.com.mind5.business.personSearch.model.action.StdPerarchEnforceEmailPerson;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckReadEmailPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerarchSelectEmailPerson extends DeciTreeTemplateRead<PerarchInfo> {
	
	public RootPerarchSelectEmailPerson(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PerarchInfo> buildCheckerHook(DeciTreeOption<PerarchInfo> option) {
		List<ModelChecker<PerarchInfo>> queue = new ArrayList<>();		
		ModelChecker<PerarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerarchCheckReadEmailPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStd<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerarchInfo> enforceEmailPerson = new StdPerarchEnforceEmailPerson(option);	
		ActionLazy<PerarchInfo> select = new LazyPerarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceEmailPerson.addPostAction(select);

		actions.add(enforceEmailPerson);		
		return actions;
	}
}
