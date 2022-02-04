package br.com.mind5.stats.statsUserAccount.userAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.LazySuseracNodeSelectLtm;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.LazySuseracNodeZerofy;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.StdSuseracMergeCalonthLtm;


public final class RootSuseracSelectLtm extends DeciTreeTemplateWrite<SuseracInfo> {
	
	public RootSuseracSelectLtm(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SuseracInfo> buildCheckerHook(DeciTreeOption<SuseracInfo> option) {
		List<ModelChecker<SuseracInfo>> queue = new ArrayList<>();		
		ModelChecker<SuseracInfo> checker;
		
		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SuseracInfo>> buildActionsOnPassedHook(DeciTreeOption<SuseracInfo> option) {
		List<ActionStd<SuseracInfo>> actions = new ArrayList<>();

		ActionStd<SuseracInfo> mergeCalonthLtm = new StdSuseracMergeCalonthLtm(option);
		ActionLazy<SuseracInfo> nodeL1 = new LazySuseracNodeSelectLtm(option.conn, option.schemaName);
		ActionLazy<SuseracInfo> zerofy = new LazySuseracNodeZerofy(option.conn, option.schemaName);		
		
		mergeCalonthLtm.addPostAction(nodeL1);
		nodeL1.addPostAction(zerofy);
		
		actions.add(mergeCalonthLtm);
		return actions;
	}
}
