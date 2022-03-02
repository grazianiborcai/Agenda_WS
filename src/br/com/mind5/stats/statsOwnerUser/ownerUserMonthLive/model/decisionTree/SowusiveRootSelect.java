package br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.info.SowusiveInfo;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action.SowusiveVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action.SowusiveVisiMergeMonth;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action.SowusiveVisiMergeState;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.action.SowusiveVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.checker.SowusiveCheckLangu;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.checker.SowusiveCheckOwner;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthLive.model.checker.SowusiveCheckRead;


public final class SowusiveRootSelect extends DeciTreeTemplateWrite<SowusiveInfo> {
	
	public SowusiveRootSelect(DeciTreeOption<SowusiveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowusiveInfo> buildCheckerHook(DeciTreeOption<SowusiveInfo> option) {
		List<ModelChecker<SowusiveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowusiveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowusiveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowusiveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowusiveInfo> option) {
		List<ActionStd<SowusiveInfo>> actions = new ArrayList<>();

		ActionStd<SowusiveInfo> select = new ActionStdCommom<SowusiveInfo>(option, SowusiveVisiMergeToSelect.class);
		ActionLazy<SowusiveInfo> enforceLChanged = new ActionLazyCommom<SowusiveInfo>(option.conn, option.schemaName, SowusiveVisiEnforceLChanged.class);
		ActionLazy<SowusiveInfo> mergeState = new ActionLazyCommom<SowusiveInfo>(option.conn, option.schemaName, SowusiveVisiMergeState.class);
		ActionLazy<SowusiveInfo> mergeMonth = new ActionLazyCommom<SowusiveInfo>(option.conn, option.schemaName, SowusiveVisiMergeMonth.class);		
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		mergeState.addPostAction(mergeMonth);
		
		actions.add(select);
		return actions;
	}
}
