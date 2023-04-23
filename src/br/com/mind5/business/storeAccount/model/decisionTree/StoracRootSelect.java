package br.com.mind5.business.storeAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.business.storeAccount.model.action.StoracVisiMergePayparult;
import br.com.mind5.business.storeAccount.model.action.StoracVisiNodeSelectL1;
import br.com.mind5.business.storeAccount.model.checker.StoracCheckLangu;
import br.com.mind5.business.storeAccount.model.checker.StoracCheckOwner;
import br.com.mind5.business.storeAccount.model.checker.StoracCheckRead;
import br.com.mind5.business.storeAccount.model.checker.StoracCheckStore;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;


public final class StoracRootSelect extends DeciTreeTemplateWrite<StoracInfo> {
	
	public StoracRootSelect(DeciTreeOption<StoracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StoracInfo> buildCheckerHook(DeciTreeOption<StoracInfo> option) {
		List<ModelChecker<StoracInfo>> queue = new ArrayList<>();
		ModelChecker<StoracInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StoracCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoracCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoracCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StoracCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StoracInfo>> buildActionsOnPassedHook(DeciTreeOption<StoracInfo> option) {
		List<ActionStd<StoracInfo>> actions = new ArrayList<>();

		ActionStd <StoracInfo> mergePayparult = new ActionStdCommom <StoracInfo>(option, StoracVisiMergePayparult.class);
		ActionLazy<StoracInfo> nodeL1         = new ActionLazyCommom<StoracInfo>(option, StoracVisiNodeSelectL1.class);
		
		mergePayparult.addPostAction(nodeL1);
		
		actions.add(mergePayparult);
		return actions;
	}
}
