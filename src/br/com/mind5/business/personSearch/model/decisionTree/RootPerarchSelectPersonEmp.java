package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchEnforcePerson;
import br.com.mind5.business.personSearch.model.action.LazyPerarchRootSelect;
import br.com.mind5.business.personSearch.model.action.StdPerarchEnforceCategEmp;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckReadPerson;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;

public final class RootPerarchSelectPersonEmp extends DeciTreeTemplateReadV2<PerarchInfo> {
	
	public RootPerarchSelectPersonEmp(DeciTreeOption<PerarchInfo> option) {
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
		checker = new PerarchCheckReadPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStdV1<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PerarchInfo> enforceCateg = new StdPerarchEnforceCategEmp(option);	
		ActionLazyV1<PerarchInfo> enforcePerson = new LazyPerarchEnforcePerson(option.conn, option.schemaName);
		ActionLazyV1<PerarchInfo> select = new LazyPerarchRootSelect(option.conn, option.schemaName);
		
		enforceCateg.addPostAction(enforcePerson);
		enforcePerson.addPostAction(select);

		actions.add(enforceCateg);		
		return actions;
	}
}
