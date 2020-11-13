package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonDaoDelete;
import br.com.mind5.business.person.model.action.LazyPersonDaoUpdate;
import br.com.mind5.business.person.model.action.LazyPersonEnforceLChanged;
import br.com.mind5.business.person.model.action.LazyPersonMergeUsername;
import br.com.mind5.business.person.model.action.StdPersonMergeToSelect;
import br.com.mind5.business.person.model.checker.PersonCheckDelete;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPersonDelete extends DeciTreeTemplateWrite<PersonInfo> {
	
	public RootPersonDelete(DeciTreeOption<PersonInfo> option) {
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
		
		ActionStd<PersonInfo> select = new StdPersonMergeToSelect(option);	
		ActionLazy<PersonInfo> enforceLChanged = new LazyPersonEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> updatePerson = new LazyPersonDaoUpdate(option.conn, option.schemaName);
		ActionLazy<PersonInfo> deletePerson = new LazyPersonDaoDelete(option.conn, option.schemaName);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updatePerson);
		updatePerson.addPostAction(deletePerson);
		
		actions.add(select);
		
		return actions;
	}
}
