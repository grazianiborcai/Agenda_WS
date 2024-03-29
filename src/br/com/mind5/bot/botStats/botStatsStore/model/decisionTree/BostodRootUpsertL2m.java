package br.com.mind5.bot.botStats.botStatsStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsStore.info.BostodInfo;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiMergeCalonthL2m;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiMergeDaemon;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiMergeStolis;
import br.com.mind5.bot.botStats.botStatsStore.model.action.BostodVisiRootUpsertMonth;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckLangu;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckOwner;
import br.com.mind5.bot.botStats.botStatsStore.model.checker.BostodCheckWriteL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class BostodRootUpsertL2m extends DeciTreeTemplateRead<BostodInfo> {
	
	public BostodRootUpsertL2m(DeciTreeOption<BostodInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostodInfo> buildCheckerHook(DeciTreeOption<BostodInfo> option) {
		List<ModelChecker<BostodInfo>> queue = new ArrayList<>();		
		ModelChecker<BostodInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new BostodCheckWriteL2m(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostodCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostodCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostodInfo>> buildActionsOnPassedHook(DeciTreeOption<BostodInfo> option) {
		List<ActionStd<BostodInfo>> actions = new ArrayList<>();

		ActionStd<BostodInfo> mergeDaemon = new ActionStdCommom<BostodInfo>(option, BostodVisiMergeDaemon.class);
		ActionLazy<BostodInfo> mergeStolis = new ActionLazyCommom<BostodInfo>(option, BostodVisiMergeStolis.class);
		ActionLazy<BostodInfo> mergeCalonth = new ActionLazyCommom<BostodInfo>(option, BostodVisiMergeCalonthL2m.class);
		ActionLazy<BostodInfo> upsert = new ActionLazyCommom<BostodInfo>(option, BostodVisiRootUpsertMonth.class);
		
		mergeDaemon.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeCalonth);
		mergeCalonth.addPostAction(upsert);
		
		actions.add(mergeDaemon);
		return actions;
	}
}
