package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.PersonVisiDaoDelete;
import br.com.mind5.business.person.model.action.PersonVisiDaoUpdate;
import br.com.mind5.business.person.model.action.PersonVisiEnforceLChanged;
import br.com.mind5.business.person.model.action.PersonVisiMergeUsername;
import br.com.mind5.business.person.model.action.PersonVisiNodePerbioDelete;
import br.com.mind5.business.person.model.action.PersonVisiRootSelect;
import br.com.mind5.business.person.model.checker.PersonCheckDelete;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonRootDelete extends DeciTreeTemplateWrite<PersonInfo> {
	
	public PersonRootDelete(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PersonCheckDelete(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonCheckLangu(checkerOption);
		queue.add(checker);	
			
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonCheckExist(checkerOption);
		queue.add(checker);		
		
		 return new ModelCheckerHelperQueue<PersonInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> select = new ActionStdCommom<PersonInfo>(option, PersonVisiRootSelect.class);	
		ActionLazy<PersonInfo> enforceLChanged = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceLChanged.class);
		ActionLazy<PersonInfo> enforceLChangedBy = new ActionLazyCommom<PersonInfo>(option, PersonVisiMergeUsername.class);
		ActionLazy<PersonInfo> updatePerson = new ActionLazyCommom<PersonInfo>(option, PersonVisiDaoUpdate.class);
		ActionLazy<PersonInfo> deletePerbio = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodePerbioDelete.class);
		ActionLazy<PersonInfo> deletePerson = new ActionLazyCommom<PersonInfo>(option, PersonVisiDaoDelete.class);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updatePerson);
		updatePerson.addPostAction(deletePerbio);
		deletePerbio.addPostAction(deletePerson);
		
		actions.add(select);
		
		return actions;
	}
}
