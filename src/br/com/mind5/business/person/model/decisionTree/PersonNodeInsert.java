package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.PersonVisiNodeName;
import br.com.mind5.business.person.model.action.PersonVisiDaoInsert;
import br.com.mind5.business.person.model.action.PersonVisiEnforceBirthdate;
import br.com.mind5.business.person.model.action.PersonVisiEnforceCreatedBy;
import br.com.mind5.business.person.model.action.PersonVisiEnforceCreatedOn;
import br.com.mind5.business.person.model.action.PersonVisiEnforceLChanged;
import br.com.mind5.business.person.model.action.PersonVisiMergeUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonNodeInsert extends DeciTreeTemplateWrite<PersonInfo> {
	
	public PersonNodeInsert(DeciTreeOption<PersonInfo> option) {
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
		
		ActionStd<PersonInfo> enforceLChanged = new ActionStdCommom<PersonInfo>(option, PersonVisiEnforceLChanged.class);
		ActionLazy<PersonInfo> enforceLChangedBy = new ActionLazyCommom<PersonInfo>(option, PersonVisiMergeUsername.class);
		ActionLazy<PersonInfo> enforceCreatedOn = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceCreatedOn.class);	
		ActionLazy<PersonInfo> enforceCreatedBy = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceCreatedBy.class);
		ActionLazy<PersonInfo> nodeName = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeName.class);	
		ActionLazy<PersonInfo> enforceBirthdate = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceBirthdate.class);	
		ActionLazy<PersonInfo> insert = new ActionLazyCommom<PersonInfo>(option, PersonVisiDaoInsert.class);
		
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceCreatedOn);
		enforceCreatedOn.addPostAction(enforceCreatedBy);
		enforceCreatedBy.addPostAction(nodeName);
		nodeName.addPostAction(enforceBirthdate);
		enforceBirthdate.addPostAction(insert);
		
		actions.add(enforceLChanged);
		return actions;
	}
}
