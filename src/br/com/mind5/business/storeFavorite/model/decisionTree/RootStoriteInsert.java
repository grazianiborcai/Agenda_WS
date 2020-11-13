package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.LazyStoriteRootSelect;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckLangu;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckOwner;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckStore;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckUser;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckWrite;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;

public final class RootStoriteInsert extends DeciTreeTemplateWriteV2<StoriteInfo> {
	
	public RootStoriteInsert(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelCheckerV1<StoriteInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoriteCheckWrite(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckStore(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;	
		checker = new StoriteCheckUser(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStdV1<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStdV1<StoriteInfo> nodeL1 = new NodeStoriteInsert(option).toAction();
		ActionLazy<StoriteInfo> select = new LazyStoriteRootSelect(option.conn, option.schemaName);
		
		nodeL1.addPostAction(select);
		
		actions.add(nodeL1);	
		return actions;
	}
}
