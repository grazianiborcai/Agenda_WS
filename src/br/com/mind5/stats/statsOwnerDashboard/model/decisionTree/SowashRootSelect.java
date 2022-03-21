package br.com.mind5.stats.statsOwnerDashboard.model.decisionTree;

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
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiEnforceLChanged;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiMergeSowedul;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiMergeSoword;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiMergeSowot;
import br.com.mind5.stats.statsOwnerDashboard.model.action.SowashVisiMergeSowus;
import br.com.mind5.stats.statsOwnerDashboard.model.checker.SowashCheckRead;


public final class SowashRootSelect extends DeciTreeTemplateWrite<SowashInfo> {
	
	public SowashRootSelect(DeciTreeOption<SowashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowashInfo> buildCheckerHook(DeciTreeOption<SowashInfo> option) {
		List<ModelChecker<SowashInfo>> queue = new ArrayList<>();
		ModelChecker<SowashInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;
		checker = new SowashCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowashInfo>> buildActionsOnPassedHook(DeciTreeOption<SowashInfo> option) {
		List<ActionStd<SowashInfo>> actions = new ArrayList<>();

		ActionStd<SowashInfo> mergeSowot = new ActionStdCommom<SowashInfo>(option, SowashVisiMergeSowot.class);
		ActionLazy<SowashInfo> mergeSoword = new ActionLazyCommom<SowashInfo>(option, SowashVisiMergeSoword.class);
		ActionLazy<SowashInfo> mergeSowus = new ActionLazyCommom<SowashInfo>(option, SowashVisiMergeSowus.class);
		ActionLazy<SowashInfo> mergeSowedul = new ActionLazyCommom<SowashInfo>(option, SowashVisiMergeSowedul.class);
//		ActionLazy<SowashInfo> mergeSowal = new ActionLazyCommom<SowashInfo>(option, SowashVisiMergeSowal.class);
		ActionLazy<SowashInfo> enforceLChanged = new ActionLazyCommom<SowashInfo>(option, SowashVisiEnforceLChanged.class);
		
		
		mergeSowot.addPostAction(mergeSoword);
		mergeSoword.addPostAction(mergeSowus);
		mergeSowus.addPostAction(mergeSowedul);
		mergeSowedul.addPostAction(enforceLChanged);
//		mergeSowal.addPostAction(enforceLChanged);
		
		actions.add(mergeSowot);
		return actions;
	}
}
