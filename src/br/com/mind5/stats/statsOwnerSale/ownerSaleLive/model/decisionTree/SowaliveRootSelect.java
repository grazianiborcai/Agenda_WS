package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.SowaliveVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.SowaliveVisiMergeState;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.action.SowaliveVisiMergeToSelect;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckLangu;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckOwner;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.model.checker.SowaliveCheckRead;


public final class SowaliveRootSelect extends DeciTreeTemplateWrite<SowaliveInfo> {
	
	public SowaliveRootSelect(DeciTreeOption<SowaliveInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowaliveInfo> buildCheckerHook(DeciTreeOption<SowaliveInfo> option) {
		List<ModelChecker<SowaliveInfo>> queue = new ArrayList<>();		
		ModelChecker<SowaliveInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowaliveCheckRead(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowaliveCheckLangu(checkerOption);
		queue.add(checker);
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SowaliveCheckOwner(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowaliveInfo>> buildActionsOnPassedHook(DeciTreeOption<SowaliveInfo> option) {
		List<ActionStd<SowaliveInfo>> actions = new ArrayList<>();

		ActionStd<SowaliveInfo> select = new ActionStdCommom<SowaliveInfo>(option, SowaliveVisiMergeToSelect.class);
		ActionLazy<SowaliveInfo> enforceLChanged = new ActionLazyCommom<SowaliveInfo>(option.conn, option.schemaName, SowaliveVisiEnforceLChanged.class);
		ActionLazy<SowaliveInfo> mergeState = new ActionLazyCommom<SowaliveInfo>(option.conn, option.schemaName, SowaliveVisiMergeState.class);
		
		select.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(mergeState);
		
		actions.add(select);
		return actions;
	}
}
