package br.com.mind5.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.action.PersonapVisiMergeGender;
import br.com.mind5.business.personSnapshot.model.action.PersonapVisiMergeToSelect;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckOwner;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;

public final class PersonapRootSelect extends DeciTreeTemplateRead<PersonapInfo> {
	
	public PersonapRootSelect(DeciTreeOption<PersonapInfo> option) {
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
		checker = new PersonapCheckRead(checkerOption);
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
		
		ActionStd<PersonapInfo> select = new ActionStdCommom<PersonapInfo>(option, PersonapVisiMergeToSelect.class);		
		ActionLazy<PersonapInfo> mergeGender = new ActionLazyCommom<PersonapInfo>(option, PersonapVisiMergeGender.class);
		
		select.addPostAction(mergeGender);		
		actions.add(select);
		
		return actions;
	}
}
