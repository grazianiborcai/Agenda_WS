package br.com.mind5.bot.botStats.botStatsCustomer.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.bot.botStats.botStatsCustomer.info.BostusInfo;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiMergeCalonthL2m;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiMergeDaemon;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiMergeCuslis;
import br.com.mind5.bot.botStats.botStatsCustomer.model.action.BostusVisiRootUpsertMonth;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckLangu;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckOwner;
import br.com.mind5.bot.botStats.botStatsCustomer.model.checker.BostusCheckWriteL2m;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionLazyCommom;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;


public final class BostusRootUpsertL2m extends DeciTreeTemplateRead<BostusInfo> {
	
	public BostusRootUpsertL2m(DeciTreeOption<BostusInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<BostusInfo> buildCheckerHook(DeciTreeOption<BostusInfo> option) {
		List<ModelChecker<BostusInfo>> queue = new ArrayList<>();		
		ModelChecker<BostusInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new BostusCheckWriteL2m(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostusCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new BostusCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<BostusInfo>> buildActionsOnPassedHook(DeciTreeOption<BostusInfo> option) {
		List<ActionStd<BostusInfo>> actions = new ArrayList<>();

		ActionStd<BostusInfo> mergeDaemon = new ActionStdCommom<BostusInfo>(option, BostusVisiMergeDaemon.class);
		ActionLazy<BostusInfo> mergeCuslis = new ActionLazyCommom<BostusInfo>(option, BostusVisiMergeCuslis.class);
		ActionLazy<BostusInfo> mergeCalonth = new ActionLazyCommom<BostusInfo>(option, BostusVisiMergeCalonthL2m.class);
		ActionLazy<BostusInfo> upsert = new ActionLazyCommom<BostusInfo>(option, BostusVisiRootUpsertMonth.class);
		
		mergeDaemon.addPostAction(mergeCuslis);
		mergeCuslis.addPostAction(mergeCalonth);
		mergeCalonth.addPostAction(upsert);
		
		actions.add(mergeDaemon);
		return actions;
	}
}
