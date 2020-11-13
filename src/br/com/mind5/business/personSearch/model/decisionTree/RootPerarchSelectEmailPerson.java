package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchRootSelectAuth;
import br.com.mind5.business.personSearch.model.action.StdPerarchEnforceEmailPerson;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckReadEmailPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPerarchSelectEmailPerson extends DeciTreeTemplateReadV2<PerarchInfo> {
	
	public RootPerarchSelectEmailPerson(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PerarchInfo> buildCheckerHook(DeciTreeOption<PerarchInfo> option) {
		List<ModelCheckerV1<PerarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PerarchInfo> checker;
		ModelCheckerOption checkerOption;	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PerarchCheckReadEmailPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStdV2<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStdV2<PerarchInfo> enforceEmailPerson = new StdPerarchEnforceEmailPerson(option);	
		ActionLazy<PerarchInfo> select = new LazyPerarchRootSelectAuth(option.conn, option.schemaName);
		
		enforceEmailPerson.addPostAction(select);

		actions.add(enforceEmailPerson);		
		return actions;
	}
}
