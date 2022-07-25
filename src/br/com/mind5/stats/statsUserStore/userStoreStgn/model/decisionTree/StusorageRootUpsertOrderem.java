package br.com.mind5.stats.statsUserStore.userStoreStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStoreStgn.info.StusorageInfo;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StusorageVisiNodeUpsertOrderem;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.action.StusorageVisiMergeOrdemist;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckOrderem;
import br.com.mind5.stats.statsUserStore.userStoreStgn.model.checker.StusorageCheckWriteOrderem;


public final class StusorageRootUpsertOrderem extends DeciTreeTemplateWrite<StusorageInfo> {
	
	public StusorageRootUpsertOrderem(DeciTreeOption<StusorageInfo> option) {
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

		ActionStd<StusorageInfo> mergeOrdemist = new ActionStdCommom<StusorageInfo>(option, StusorageVisiMergeOrdemist.class);
		ActionLazy<StusorageInfo> nodeL1 = new ActionLazyCommom<StusorageInfo>(option, StusorageVisiNodeUpsertOrderem.class);
		
		mergeOrdemist.addPostAction(nodeL1);
		
		actions.add(mergeOrdemist);
		return actions;
	}
}
