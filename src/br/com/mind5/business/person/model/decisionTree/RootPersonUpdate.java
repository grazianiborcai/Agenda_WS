package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonEnforceLChanged;
import br.com.mind5.business.person.model.action.LazyPersonEnforceNameSearch;
import br.com.mind5.business.person.model.action.LazyPersonMergeUsername;
import br.com.mind5.business.person.model.action.LazyPersonNodeCpfL1;
import br.com.mind5.business.person.model.action.LazyPersonNodeEmailL1;
import br.com.mind5.business.person.model.action.LazyPersonNodeSnapshot;
import br.com.mind5.business.person.model.action.StdPersonMergeToUpdate;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.person.model.checker.PersonCheckGender;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.business.person.model.checker.PersonCheckOwner;
import br.com.mind5.business.person.model.checker.PersonCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPersonUpdate extends DeciTreeWriteTemplate<PersonInfo> {
	
	public RootPersonUpdate(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildDecisionCheckerHook(DeciTreeOption<PersonInfo> option) {
		List<ModelChecker<PersonInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new PersonCheckUpdate(checkerOption);
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
		checker = new PersonCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonCheckGender(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonCheckExist(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> mergeToUpdate = new StdPersonMergeToUpdate(option);	
		ActionLazy<PersonInfo> cpf = new LazyPersonNodeCpfL1(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> email = new LazyPersonNodeEmailL1(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> enforceLChanged = new LazyPersonEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceNameSearch = new LazyPersonEnforceNameSearch(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> snapshot = new LazyPersonNodeSnapshot(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(cpf);
		cpf.addPostAction(email);
		email.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(enforceNameSearch);
		enforceNameSearch.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
