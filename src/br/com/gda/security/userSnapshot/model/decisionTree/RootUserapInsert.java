package br.com.gda.security.userSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.security.userSnapshot.info.UserapInfo;
import br.com.gda.security.userSnapshot.model.action.LazyUserapRootSelect;
import br.com.gda.security.userSnapshot.model.action.StdUserapInsert;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckOwner;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckUser;
import br.com.gda.security.userSnapshot.model.checker.UserapCheckWrite;

public final class RootUserapInsert extends DeciTreeWriteTemplate<UserapInfo> {
	
	public RootUserapInsert(DeciTreeOption<UserapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<UserapInfo> buildDecisionCheckerHook(DeciTreeOption<UserapInfo> option) {
		final boolean EXIST = true;
		
		List<ModelChecker<UserapInfo>> queue = new ArrayList<>();		
		ModelChecker<UserapInfo> checker;	
		ModelCheckerOption checkerOption;
		
		checker = new UserapCheckWrite();
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserapCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = EXIST;	
		checker = new UserapCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<UserapInfo>> buildActionsOnPassedHook(DeciTreeOption<UserapInfo> option) {
		List<ActionStd<UserapInfo>> actions = new ArrayList<>();	
		
		ActionStd<UserapInfo> insert = new StdUserapInsert(option);
		ActionLazy<UserapInfo> select = new LazyUserapRootSelect(option.conn, option.schemaName);
		
		insert.addPostAction(select);
		
		actions.add(insert);	
		return actions;
	}
}
