package br.com.gda.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.business.personSnapshot.model.action.LazyPersonapRootSelect;
import br.com.gda.business.personSnapshot.model.action.StdPersonapInsert;
import br.com.gda.business.personSnapshot.model.checker.PersonapCheckOwner;
import br.com.gda.business.personSnapshot.model.checker.PersonapCheckWrite;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootPersonapInsert extends DeciTreeWriteTemplate<PersonapInfo> {
	
	public RootPersonapInsert(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<PersonapInfo> buildDecisionCheckerHook(DeciTreeOption<PersonapInfo> option) {
		final boolean EXIST_ON_DB = true;	
		
		List<ModelChecker<PersonapInfo>> queue = new ArrayList<>();		
		ModelChecker<PersonapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checker = new PersonapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST_ON_DB;		
		checker = new PersonapCheckOwner(checkerOption);
		queue.add(checker);
			
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<PersonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonapInfo> option) {
		List<ActionStd<PersonapInfo>> actions = new ArrayList<>();
		
		ActionStd<PersonapInfo> insert = new StdPersonapInsert(option);	
		ActionLazy<PersonapInfo> select = new LazyPersonapRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(select);		
		actions.add(insert);		
		
		return actions;
	}
}
