package br.com.mind5.stats.statsOwnerDashboard.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsOwnerDashboard.info.SowashInfo;
import br.com.mind5.stats.statsOwnerDashboard.model.action.LazySowashMergeSowal;
import br.com.mind5.stats.statsOwnerDashboard.model.action.LazySowashMergeSowedul;
import br.com.mind5.stats.statsOwnerDashboard.model.action.LazySowashMergeSoword;
import br.com.mind5.stats.statsOwnerDashboard.model.action.LazySowashMergeSowus;
import br.com.mind5.stats.statsOwnerDashboard.model.action.StdSowashMergeSowot;


public final class RootSowashSelect extends DeciTreeTemplateWrite<SowashInfo> {
	
	public RootSowashSelect(DeciTreeOption<SowashInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SowashInfo> buildCheckerHook(DeciTreeOption<SowashInfo> option) {
		List<ModelChecker<SowashInfo>> queue = new ArrayList<>();
		ModelChecker<SowashInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SowashInfo>> buildActionsOnPassedHook(DeciTreeOption<SowashInfo> option) {
		List<ActionStd<SowashInfo>> actions = new ArrayList<>();

		ActionStd<SowashInfo> mergeSowot = new StdSowashMergeSowot(option);
		ActionLazy<SowashInfo> mergeSoword = new LazySowashMergeSoword(option.conn, option.schemaName);
		ActionLazy<SowashInfo> mergeSowus = new LazySowashMergeSowus(option.conn, option.schemaName);
		ActionLazy<SowashInfo> mergeSowedul = new LazySowashMergeSowedul(option.conn, option.schemaName);
		ActionLazy<SowashInfo> mergeSowal = new LazySowashMergeSowal(option.conn, option.schemaName);
		
		
		mergeSowot.addPostAction(mergeSoword);
		mergeSoword.addPostAction(mergeSowus);
		mergeSowus.addPostAction(mergeSowedul);
		mergeSowedul.addPostAction(mergeSowal);
		
		actions.add(mergeSowot);
		return actions;
	}
}
