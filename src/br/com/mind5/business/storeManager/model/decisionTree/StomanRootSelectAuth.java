package br.com.mind5.business.storeManager.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.business.storeManager.model.action.StomanVisiMergeUsername;
import br.com.mind5.business.storeManager.model.action.StomanVisiRootSelect;
import br.com.mind5.business.storeManager.model.checker.StomanCheckLangu;
import br.com.mind5.business.storeManager.model.checker.StomanCheckOwner;
import br.com.mind5.business.storeManager.model.checker.StomanCheckReadAuth;
import br.com.mind5.business.storeManager.model.checker.StomanCheckUsername;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class StomanRootSelectAuth extends DeciTreeTemplateRead<StomanInfo> {
	
	public StomanRootSelectAuth(DeciTreeOption<StomanInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StomanInfo> buildCheckerHook(DeciTreeOption<StomanInfo> option) {
		List<ModelChecker<StomanInfo>> queue = new ArrayList<>();		
		ModelChecker<StomanInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new StomanCheckReadAuth(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StomanCheckUsername(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StomanInfo>> buildActionsOnPassedHook(DeciTreeOption<StomanInfo> option) {
		List<ActionStd<StomanInfo>> actions = new ArrayList<>();

		ActionStd<StomanInfo> mergeUsername = new ActionStdCommom<StomanInfo>(option, StomanVisiMergeUsername.class);
		ActionLazy<StomanInfo> select = new ActionLazyCommom<StomanInfo>(option, StomanVisiRootSelect.class);
		
		mergeUsername.addPostAction(select);
		
		actions.add(mergeUsername);
		return actions;
	}
}
