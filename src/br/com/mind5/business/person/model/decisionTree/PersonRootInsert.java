package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.PersonVisiNodeEmailL1;
import br.com.mind5.business.person.model.action.PersonVisiNodeGenderL1;
import br.com.mind5.business.person.model.action.PersonVisiNodeInsert;
import br.com.mind5.business.person.model.action.PersonVisiNodePerbioUpsertdel;
import br.com.mind5.business.person.model.action.PersonVisiNodeSnapshot;
import br.com.mind5.business.person.model.checker.PersonCheckBirthdate;
import br.com.mind5.business.person.model.checker.PersonCheckEntiteg;
import br.com.mind5.business.person.model.checker.PersonCheckInsert;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.business.person.model.checker.PersonCheckOwner;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonRootInsert extends DeciTreeTemplateWrite<PersonInfo> {
	
	public PersonRootInsert(DeciTreeOption<PersonInfo> option) {
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
		checker = new PersonCheckInsert(checkerOption);
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
		checker = new PersonCheckEntiteg(checkerOption);
		queue.add(checker);	
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonInfo> option) {
		List<ActionStd<PersonInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonInfo> nodeSafe = new PersonNodeSafe(option).toAction();
		ActionStd<PersonInfo> cpf = new PersonNodeCpfL1(option).toAction();	
		ActionLazy<PersonInfo> email = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeEmailL1.class);
		ActionLazy<PersonInfo> gender = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeGenderL1.class);		
		ActionLazy<PersonInfo> insert = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeInsert.class);		
		ActionLazy<PersonInfo> snapshot = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeSnapshot.class);
		ActionLazy<PersonInfo> upsertdelPerbio = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodePerbioUpsertdel.class);
		
		cpf.addPostAction(email);
		email.addPostAction(gender);
		gender.addPostAction(insert);
		insert.addPostAction(snapshot);
		snapshot.addPostAction(upsertdelPerbio);
		
		actions.add(nodeSafe);
		actions.add(cpf);
		
		return actions;
	}
}
