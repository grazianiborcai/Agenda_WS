package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapInsert;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeComp;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeUser;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckOwner;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckStore;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootStorapInsert extends DeciTreeWriteTemplate<StorapInfo> {
	
	public RootStorapInsert(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorapInfo> buildDecisionCheckerHook(DeciTreeOption<StorapInfo> option) {
		List<ModelChecker<StorapInfo>> queue = new ArrayList<>();		
		ModelChecker<StorapInfo> checker;
		ModelCheckerOption checkerOption;		
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StorapCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckOwner(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorapCheckStore(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStd<StorapInfo>> actions = new ArrayList<>();

		ActionStd<StorapInfo> nodePerson = new NodeStorapPerson(option).toAction();
		ActionLazy<StorapInfo> nodeComp = new LazyStorapNodeComp(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeUser = new LazyStorapNodeUser(option.conn, option.schemaName);
		ActionLazy<StorapInfo> insert = new LazyStorapInsert(option.conn, option.schemaName);
		
		nodePerson.addPostAction(nodeComp);
		nodeComp.addPostAction(nodeUser);
		nodeUser.addPostAction(insert);
		
		actions.add(nodePerson);	
		return actions;
	}
}
