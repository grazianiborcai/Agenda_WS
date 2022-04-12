package br.com.mind5.business.personSearch.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.business.personSearch.model.action.PerarchVisiRootSelect;
import br.com.mind5.business.personSearch.model.action.PerarchVisiEnforceCategEmp;
import br.com.mind5.business.personSearch.model.action.PerarchVisiEnforcePerson;
import br.com.mind5.business.personSearch.model.checker.PerarchCheckReadPerson;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PerarchRootSelectPersonEmp extends DeciTreeTemplateRead<PerarchInfo> {
	
	public PerarchRootSelectPersonEmp(DeciTreeOption<PerarchInfo> option) {
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
		checker = new PerarchCheckReadPerson(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PerarchInfo>> buildActionsOnPassedHook(DeciTreeOption<PerarchInfo> option) {
		List<ActionStd<PerarchInfo>> actions = new ArrayList<>();
		
		ActionStd<PerarchInfo> enforceCateg = new ActionStdCommom<PerarchInfo>(option, PerarchVisiEnforceCategEmp.class);	
		ActionLazy<PerarchInfo> enforcePerson = new ActionLazyCommom<PerarchInfo>(option, PerarchVisiEnforcePerson.class);
		ActionLazy<PerarchInfo> select = new ActionLazyCommom<PerarchInfo>(option, PerarchVisiRootSelect.class);
		
		enforceCateg.addPostAction(enforcePerson);
		enforcePerson.addPostAction(select);

		actions.add(enforceCateg);		
		return actions;
	}
}
