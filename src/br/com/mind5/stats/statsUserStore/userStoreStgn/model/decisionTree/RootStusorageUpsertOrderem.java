package br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.LazyStusorageNodeUpsertOrderem;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StdStusorageMergeOrdemist;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckOrderem;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckWriteOrderem;


public final class RootStusorageUpsertOrderem extends DeciTreeTemplateWrite<StusorageInfo> {
	
	public RootStusorageUpsertOrderem(DeciTreeOption<StusorageInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorageInfo> buildCheckerHook(DeciTreeOption<StusorageInfo> option) {
		List<ModelChecker<StusorageInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorageInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorageCheckWriteOrderem(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorageCheckOrderem(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorageInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorageInfo> option) {
		List<ActionStd<StusorageInfo>> actions = new ArrayList<>();

		ActionStd<StusorageInfo> mergeOrdemist = new StdStusorageMergeOrdemist(option);
		ActionLazy<StusorageInfo> nodeL1 = new LazyStusorageNodeUpsertOrderem(option.conn, option.schemaName);
		
		mergeOrdemist.addPostAction(nodeL1);
		
		actions.add(mergeOrdemist);
		return actions;
	}
}
