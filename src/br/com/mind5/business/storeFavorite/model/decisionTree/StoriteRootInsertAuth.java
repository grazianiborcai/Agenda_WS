package br.com.mind5.business.storeFavorite.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeFavorite.info.StoriteInfo;
import br.com.mind5.business.storeFavorite.model.action.StoriteVisiRootInsert;
import br.com.mind5.business.storeFavorite.model.action.StoriteVisiMergeUsername;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckLangu;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckOwner;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckStore;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckUsername;
import br.com.mind5.business.storeFavorite.model.checker.StoriteCheckWriteAuth;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;

public final class StoriteRootInsertAuth extends DeciTreeTemplateWrite<StoriteInfo> {
	
	public StoriteRootInsertAuth(DeciTreeOption<StoriteInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoriteInfo> buildCheckerHook(DeciTreeOption<StoriteInfo> option) {
		List<ModelChecker<StoriteInfo>> queue = new ArrayList<>();		
		ModelChecker<StoriteInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StoriteCheckWriteAuth(checkerOption);
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
		checker = new StoriteCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoriteInfo>> buildActionsOnPassedHook(DeciTreeOption<StoriteInfo> option) {
		List<ActionStd<StoriteInfo>> actions = new ArrayList<>();
		
		ActionStd<StoriteInfo> mergeUsername = new ActionStdCommom<StoriteInfo>(option, StoriteVisiMergeUsername.class);
		ActionLazy<StoriteInfo> insert = new ActionLazyCommom<StoriteInfo>(option, StoriteVisiRootInsert.class);
		
		mergeUsername.addPostAction(insert);
		
		actions.add(mergeUsername);	
		return actions;
	}
}
