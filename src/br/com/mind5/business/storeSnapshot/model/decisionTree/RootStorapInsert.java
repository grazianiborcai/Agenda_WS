package br.com.mind5.business.storeSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapDaoInsert;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeComp;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeStorextsnap;
import br.com.mind5.business.storeSnapshot.model.action.LazyStorapNodeUser;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckOwner;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckStore;
import br.com.mind5.business.storeSnapshot.model.checker.StorapCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStorapInsert extends DeciTreeTemplateWriteV2<StorapInfo> {
	
	public RootStorapInsert(DeciTreeOption<StorapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StorapInfo> buildCheckerHook(DeciTreeOption<StorapInfo> option) {
		List<ModelCheckerV1<StorapInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StorapInfo> checker;
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
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StorapInfo>> buildActionsOnPassedHook(DeciTreeOption<StorapInfo> option) {
		List<ActionStdV1<StorapInfo>> actions = new ArrayList<>();

		ActionStdV1<StorapInfo> nodePerson = new NodeStorapPerson(option).toAction();
		ActionLazy<StorapInfo> nodeComp = new LazyStorapNodeComp(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeUser = new LazyStorapNodeUser(option.conn, option.schemaName);
		ActionLazy<StorapInfo> insert = new LazyStorapDaoInsert(option.conn, option.schemaName);
		ActionLazy<StorapInfo> nodeStorextsnap = new LazyStorapNodeStorextsnap(option.conn, option.schemaName);
		
		nodePerson.addPostAction(nodeComp);
		nodeComp.addPostAction(nodeUser);
		nodeUser.addPostAction(insert);
		insert.addPostAction(nodeStorextsnap);
		
		actions.add(nodePerson);	
		return actions;
	}
}
