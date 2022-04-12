package br.com.mind5.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.action.PersonapVisiRootSelect;
import br.com.mind5.business.personSnapshot.model.action.PersonapVisiDaoInsert;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckOwner;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class PersonapRootInsert extends DeciTreeTemplateWrite<PersonapInfo> {
	
	public PersonapRootInsert(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonapInfo> buildCheckerHook(DeciTreeOption<PersonapInfo> option) {
		List<ModelChecker<PersonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new PersonapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new PersonapCheckOwner(checkerOption);
		queue.add(checker);
			
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonapInfo> option) {
		List<ActionStd<PersonapInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonapInfo> insert = new ActionStdCommom<PersonapInfo>(option, PersonapVisiDaoInsert.class);	
		ActionLazy<PersonapInfo> select = new ActionLazyCommom<PersonapInfo>(option, PersonapVisiRootSelect.class);	
		
		insert.addPostAction(select);		
		actions.add(insert);		
		
		return actions;
	}
}
