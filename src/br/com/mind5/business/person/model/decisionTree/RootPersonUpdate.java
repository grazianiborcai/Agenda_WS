package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.LazyPersonEnforceBirthdate;
import br.com.mind5.business.person.model.action.LazyPersonEnforceLChanged;
import br.com.mind5.business.person.model.action.LazyPersonMergeUsername;
import br.com.mind5.business.person.model.action.LazyPersonNodeCpfL1;
import br.com.mind5.business.person.model.action.LazyPersonNodeEmailL1;
import br.com.mind5.business.person.model.action.LazyPersonNodeName;
import br.com.mind5.business.person.model.action.LazyPersonNodeSnapshot;
import br.com.mind5.business.person.model.action.StdPersonMergeToUpdate;
import br.com.mind5.business.person.model.checker.PersonCheckBirthdate;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.person.model.checker.PersonCheckGender;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.business.person.model.checker.PersonCheckOwner;
import br.com.mind5.business.person.model.checker.PersonCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class RootPersonUpdate extends DeciTreeTemplateWrite<PersonInfo> {
	
	public RootPersonUpdate(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonInfo> buildCheckerHook(DeciTreeOption<PersonInfo> option) {
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
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new PersonCheckBirthdate(checkerOption);
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
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> mergeToUpdate = new StdPersonMergeToUpdate(option);	
		ActionLazy<PersonInfo> cpf = new LazyPersonNodeCpfL1(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> email = new LazyPersonNodeEmailL1(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> enforceLChanged = new LazyPersonEnforceLChanged(option.conn, option.schemaName);
		ActionLazy<PersonInfo> enforceLChangedBy = new LazyPersonMergeUsername(option.conn, option.schemaName);
		ActionLazy<PersonInfo> nodeName = new LazyPersonNodeName(option.conn, option.schemaName);	
		ActionLazy<PersonInfo> enforceBirthdate = new LazyPersonEnforceBirthdate(option.conn, option.schemaName);
		ActionLazy<PersonInfo> snapshot = new LazyPersonNodeSnapshot(option.conn, option.schemaName);
		
		mergeToUpdate.addPostAction(cpf);
		cpf.addPostAction(email);
		email.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeName);
		nodeName.addPostAction(enforceBirthdate);
		enforceBirthdate.addPostAction(snapshot);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
