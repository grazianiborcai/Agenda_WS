package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.LazyPerarchRootSelect;
import br.com.mind5.business.personSearch.model.action.StdPerarchEnforceCategEmp;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class RootPerarchSelectEmp extends DeciTreeTemplateRead<PerarchInfo> {
	
	public RootPerarchSelectEmp(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PerarchInfo> buildCheckerHook(DeciTreeOption<PerarchInfo> option) {
		List<ModelCheckerV1<PerarchInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PerarchInfo> checker;

		checker = new PerarchCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStdV1<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PerarchInfo> enforceCategEmp = new StdPerarchEnforceCategEmp(option);		
		ActionLazyV1<PerarchInfo> select = new LazyPerarchRootSelect(option.conn, option.schemaName);
		
		enforceCategEmp.addPostAction(select);

		actions.add(enforceCategEmp);		
		return actions;
	}
}
