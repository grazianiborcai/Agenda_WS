package br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.info.SowotiveInfo;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action.SowotiveVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action.SowotiveVisiMergeMonth;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action.SowotiveVisiMergeState;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.action.SowotiveVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.checker.SowotiveCheckLangu;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.checker.SowotiveCheckOwner;
import br.com.mind5.stats.statsOwnerStore.ownerStoreMonthLive.model.checker.SowotiveCheckRead;


public final class SowotiveRootSelect extends DeciTreeTemplateWrite<SowotiveInfo> {
	
	public SowotiveRootSelect(DeciTreeOption<SowotiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowotiveInfo> buildCheckerHook(DeciTreeOption<SowotiveInfo> option) {
		List<ModelChecker<SowotiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowotiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowotiveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowotiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowotiveInfo> option) {
		List<ActionStd<SowotiveInfo>> actions = new ArrayList<>();

		ActionStd<SowotiveInfo> select = new ActionStdCommom<SowotiveInfo>(option, SowotiveVisiMergeToSelect.class);
		ActionLazy<SowotiveInfo> enforceLChanged = new ActionLazyCommom<SowotiveInfo>(option, SowotiveVisiEnforceLChanged.class);
		ActionLazy<SowotiveInfo> mergeState = new ActionLazyCommom<SowotiveInfo>(option, SowotiveVisiMergeState.class);
		ActionLazy<SowotiveInfo> mergeMonth = new ActionLazyCommom<SowotiveInfo>(option, SowotiveVisiMergeMonth.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
