package br.com.mind5.business.person.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.business.person.model.action.PersonVisiNodeCpfL1;
import br.com.mind5.business.person.model.action.PersonVisiNodeEmailL1;
import br.com.mind5.business.person.model.action.PersonVisiNodeName;
import br.com.mind5.business.person.model.action.PersonVisiNodePerbioUpsertdel;
import br.com.mind5.business.person.model.action.PersonVisiNodeSnapshot;
import br.com.mind5.business.person.model.action.PersonVisiEnforceBirthdate;
import br.com.mind5.business.person.model.action.PersonVisiEnforceLChanged;
import br.com.mind5.business.person.model.action.PersonVisiMergeToUpdate;
import br.com.mind5.business.person.model.action.PersonVisiMergeUsername;
import br.com.mind5.business.person.model.checker.PersonCheckBirthdate;
import br.com.mind5.business.person.model.checker.PersonCheckExist;
import br.com.mind5.business.person.model.checker.PersonCheckGender;
import br.com.mind5.business.person.model.checker.PersonCheckLangu;
import br.com.mind5.business.person.model.checker.PersonCheckOwner;
import br.com.mind5.business.person.model.checker.PersonCheckUpdate;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonRootUpdate extends DeciTreeTemplateWrite<PersonInfo> {
	
	public PersonRootUpdate(DeciTreeOption<PersonInfo> option) {
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
		
		ActionStd<PersonInfo> mergeToUpdate = new ActionStdCommom<PersonInfo>(option, PersonVisiMergeToUpdate.class);	
		ActionLazy<PersonInfo> cpf = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeCpfL1.class);	
		ActionLazy<PersonInfo> email = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeEmailL1.class);	
		ActionLazy<PersonInfo> enforceLChanged = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceLChanged.class);
		ActionLazy<PersonInfo> enforceLChangedBy = new ActionLazyCommom<PersonInfo>(option, PersonVisiMergeUsername.class);
		ActionLazy<PersonInfo> nodeName = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeName.class);	
		ActionLazy<PersonInfo> enforceBirthdate = new ActionLazyCommom<PersonInfo>(option, PersonVisiEnforceBirthdate.class);
		ActionLazy<PersonInfo> snapshot = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodeSnapshot.class);
		ActionLazy<PersonInfo> upsertdelPerbio = new ActionLazyCommom<PersonInfo>(option, PersonVisiNodePerbioUpsertdel.class);
		
		mergeToUpdate.addPostAction(cpf);
		cpf.addPostAction(email);
		email.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(nodeName);
		nodeName.addPostAction(enforceBirthdate);
		enforceBirthdate.addPostAction(snapshot);
		snapshot.addPostAction(upsertdelPerbio);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
