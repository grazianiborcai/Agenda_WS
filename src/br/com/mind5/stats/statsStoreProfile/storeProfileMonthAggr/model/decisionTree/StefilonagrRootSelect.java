package br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.decisionTree;

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
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action.StefilonagrVisiMergeCalonth;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.action.StefilonagrVisiMergeToSelect;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckLangu;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckOwner;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckRead;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.model.checker.StefilonagrCheckStore;


public final class StefilonagrRootSelect extends DeciTreeTemplateWrite<StefilonagrInfo> {
	
	public StefilonagrRootSelect(DeciTreeOption<StefilonagrInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StefilonagrInfo> buildCheckerHook(DeciTreeOption<StefilonagrInfo> option) {
		List<ModelChecker<StefilonagrInfo>> queue = new ArrayList<>();
		ModelChecker<StefilonagrInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new StefilonagrCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StefilonagrCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StefilonagrCheckOwner(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;
		checker = new StefilonagrCheckStore(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StefilonagrInfo>> buildActionsOnPassedHook(DeciTreeOption<StefilonagrInfo> option) {
		List<ActionStd<StefilonagrInfo>> actions = new ArrayList<>();

		ActionStd<StefilonagrInfo> select = new ActionStdCommom<StefilonagrInfo>(option, StefilonagrVisiMergeToSelect.class);
		ActionLazy<StefilonagrInfo> mergeCalonth = new ActionLazyCommom<StefilonagrInfo>(option, StefilonagrVisiMergeCalonth.class);
		
		select.addPostAction(mergeCalonth);
		
		actions.add(select);
		return actions;
	}
}
