package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.PersonVisiNodeSytotauhL1;
import br.com.mind5.business.person.model.action.PersonVisiRootInsert;
import br.com.mind5.business.person.model.action.PersonVisiEnforceCategEmp;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonRootInsertEmp extends DeciTreeTemplateWrite<PersonInfo> {
	
	public PersonRootInsertEmp(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;	
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> enforceCateg = new ActionStdCommom<PersonInfo>(option, PersonVisiEnforceCategEmp.class);
		ActionLazy<PersonInfo> nodeSytotauh = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeSytotauhL1.class);
		ActionLazy<PersonInfo> insert = new ActionLazyCommom<PersonInfo>(option, PersonVisiRootInsert.class);
		
		enforceCateg.addPostAction(nodeSytotauh);
		nodeSytotauh.addPostAction(insert);
		
		actions.add(enforceCateg);
		return actions;
	}
}
