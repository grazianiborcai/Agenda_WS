package br.com.mind5.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.action.LazyPersonapMergeGender;
import br.com.mind5.business.personSnapshot.model.action.StdPersonapSelect;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootPersonapSelect extends DeciTreeReadTemplate<PersonapInfo> {
	
	public RootPersonapSelect(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonapInfo> buildDecisionCheckerHook(DeciTreeOption<PersonapInfo> option) {
		List<ModelChecker<PersonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonapInfo> checker;
		
		checker = new PersonapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonapInfo> option) {
		List<ActionStd<PersonapInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonapInfo> select = new StdPersonapSelect(option);		
		ActionLazy<PersonapInfo> mergeGender = new LazyPersonapMergeGender(option.conn, option.schemaName);
		
		select.addPostAction(mergeGender);		
		actions.add(select);
		
		return actions;
	}
}
