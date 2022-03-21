package br.com.mind5.bot.botStats.botStatsOwner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsOwner.info.BostowInfo;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiMergeCalonthL2m;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiMergeDaemon;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiMergeStolis;
import br.com.mind5.bot.botStats.botStatsOwner.model.action.BostowVisiRootUpsertMonth;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckLangu;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckOwner;
import br.com.mind5.bot.botStats.botStatsOwner.model.checker.BostowCheckWriteL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class BostowRootUpsertL2m extends DeciTreeTemplateRead<BostowInfo> {
	
	public BostowRootUpsertL2m(DeciTreeOption<BostowInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostowInfo> buildCheckerHook(DeciTreeOption<BostowInfo> option) {
		List<ModelChecker<BostowInfo>> queue = new ArrayList<>();		
		ModelChecker<BostowInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new BostowCheckWriteL2m(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostowCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostowCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostowInfo>> buildActionsOnPassedHook(DeciTreeOption<BostowInfo> option) {
		List<ActionStd<BostowInfo>> actions = new ArrayList<>();

		ActionStd<BostowInfo> mergeDaemon = new ActionStdCommom<BostowInfo>(option, BostowVisiMergeDaemon.class);
		ActionLazy<BostowInfo> mergeStolis = new ActionLazyCommom<BostowInfo>(option, BostowVisiMergeStolis.class);
		ActionLazy<BostowInfo> mergeCalonth = new ActionLazyCommom<BostowInfo>(option, BostowVisiMergeCalonthL2m.class);
		ActionLazy<BostowInfo> upsert = new ActionLazyCommom<BostowInfo>(option, BostowVisiRootUpsertMonth.class);
		
		mergeDaemon.addPostAction(mergeStolis);
		mergeStolis.addPostAction(mergeCalonth);
		mergeCalonth.addPostAction(upsert);
		
		actions.add(mergeDaemon);
		return actions;
	}
}
