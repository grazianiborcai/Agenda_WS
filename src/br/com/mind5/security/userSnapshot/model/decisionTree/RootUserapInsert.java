package br.com.mind5.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.security.userSnapshot.info.UserapInfo;
import br.com.mind5.security.userSnapshot.model.action.LazyUserapInsert;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckOwner;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckUser;
import br.com.mind5.security.userSnapshot.model.checker.UserapCheckWrite;

public final class RootUserapInsert extends DeciTreeWriteTemplate<UserapInfo> {
	
	public RootUserapInsert(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserapInfo> buildCheckerHook(DeciTreeOption<UserapInfo> option) {
		List<ModelChecker<UserapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new UserapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new UserapCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<UserapInfo>> buildActionsOnPassedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStdV1<UserapInfo>> actions = new ArrayList<>();	
		
		ActionStdV1<UserapInfo> nodePerson = new NodeUserapPerson(option).toAction();
		ActionLazyV1<UserapInfo> insert = new LazyUserapInsert(option.conn, option.schemaName);
		
		nodePerson.addPostAction(insert);
		
		actions.add(nodePerson);	
		return actions;
	}
}
