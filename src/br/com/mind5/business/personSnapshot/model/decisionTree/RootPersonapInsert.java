package br.com.mind5.business.personSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSnapshot.info.PersonapInfo;
import br.com.mind5.business.personSnapshot.model.action.LazyPersonapRootSelect;
import br.com.mind5.business.personSnapshot.model.action.StdPersonapDaoInsert;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckOwner;
import br.com.mind5.business.personSnapshot.model.checker.PersonapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootPersonapInsert extends DeciTreeTemplateWriteV2<PersonapInfo> {
	
	public RootPersonapInsert(DeciTreeOption<PersonapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<PersonapInfo> buildCheckerHook(DeciTreeOption<PersonapInfo> option) {
		List<ModelCheckerV1<PersonapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<PersonapInfo> checker;
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
			
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<PersonapInfo>> buildActionsOnPassedHook(DeciTreeOption<PersonapInfo> option) {
		List<ActionStdV1<PersonapInfo>> actions = new ArrayList<>();
		
		ActionStdV1<PersonapInfo> insert = new StdPersonapDaoInsert(option);	
		ActionLazy<PersonapInfo> select = new LazyPersonapRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(select);		
		actions.add(insert);		
		
		return actions;
	}
}
