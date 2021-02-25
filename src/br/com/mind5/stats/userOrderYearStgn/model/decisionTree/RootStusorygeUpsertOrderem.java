package br.com.mind5.stats.userOrderYearStgn.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;
import br.com.mind5.stats.userOrderYearStgn.model.action.LazyStusorygeRootUpsert;
import br.com.mind5.stats.userOrderYearStgn.model.action.StdStusorygeMergeOrdist;
import br.com.mind5.stats.userOrderYearStgn.model.checker.StusorygeCheckOrdist;
import br.com.mind5.stats.userOrderYearStgn.model.checker.StusorygeCheckWriteOrdist;


public final class RootStusorygeUpsertOrderem extends DeciTreeTemplateWrite<StusorygeInfo> {
	
	public RootStusorygeUpsertOrderem(DeciTreeOption<StusorygeInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusorygeInfo> buildCheckerHook(DeciTreeOption<StusorygeInfo> option) {
		List<ModelChecker<StusorygeInfo>> queue = new ArrayList<>();		
		ModelChecker<StusorygeInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StusorygeCheckWriteOrdist(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusorygeCheckOrdist(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusorygeInfo>> buildActionsOnPassedHook(DeciTreeOption<StusorygeInfo> option) {
		List<ActionStd<StusorygeInfo>> actions = new ArrayList<>();

		ActionStd<StusorygeInfo> mergeOrdist = new StdStusorygeMergeOrdist(option);
		ActionLazy<StusorygeInfo> upsert = new LazyStusorygeRootUpsert(option.conn, option.schemaName);
		
		mergeOrdist.addPostAction(upsert);
		
		actions.add(mergeOrdist);
		return actions;
	}
}
