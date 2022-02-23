package br.com.mind5.stats.statsStoreDashboard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsStoreDashboard.info.StorashInfo;
import br.com.mind5.stats.statsStoreDashboard.model.action.LazyStorashMergeStedmonLtm;
import br.com.mind5.stats.statsStoreDashboard.model.action.LazyStorashMergeStordMonth;
import br.com.mind5.stats.statsStoreDashboard.model.action.LazyStorashMergeStoronLtm;
import br.com.mind5.stats.statsStoreDashboard.model.action.StdStorashMergeSteddMonth;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckLangu;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckOwner;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckRead;
import br.com.mind5.stats.statsStoreDashboard.model.checker.StorashCheckStore;


public final class RootStorashSelect extends DeciTreeTemplateWrite<StorashInfo> {
	
	public RootStorashSelect(DeciTreeOption<StorashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StorashInfo> buildCheckerHook(DeciTreeOption<StorashInfo> option) {
		List<ModelChecker<StorashInfo>> queue = new ArrayList<>();
		ModelChecker<StorashInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new StorashCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorashCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorashCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StorashCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StorashInfo>> buildActionsOnPassedHook(DeciTreeOption<StorashInfo> option) {
		List<ActionStd<StorashInfo>> actions = new ArrayList<>();

		ActionStd<StorashInfo> mergeStedd = new StdStorashMergeSteddMonth(option);
		ActionLazy<StorashInfo> mergeStedmon = new LazyStorashMergeStedmonLtm(option.conn, option.schemaName);
		ActionLazy<StorashInfo> mergeStord = new LazyStorashMergeStordMonth(option.conn, option.schemaName);
		ActionLazy<StorashInfo> mergeStoron = new LazyStorashMergeStoronLtm(option.conn, option.schemaName);
		
		mergeStedd.addPostAction(mergeStedmon);
		mergeStedmon.addPostAction(mergeStord);
		mergeStord.addPostAction(mergeStoron);
		
		actions.add(mergeStedd);
		return actions;
	}
}
