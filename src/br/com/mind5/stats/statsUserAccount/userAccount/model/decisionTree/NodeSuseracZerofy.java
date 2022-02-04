package br.com.mind5.stats.statsUserAccount.userAccount.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserAccount.userAccount.info.SuseracInfo;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.StdSuseracEnforceZerofy;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.StdSuseracSuccess;
import br.com.mind5.stats.statsUserAccount.userAccount.model.checker.SuseracCheckHasData;


public final class NodeSuseracZerofy extends DeciTreeTemplateWrite<SuseracInfo> {
	
	public NodeSuseracZerofy(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SuseracInfo> buildCheckerHook(DeciTreeOption<SuseracInfo> option) {
		List<ModelChecker<SuseracInfo>> queue = new ArrayList<>();		
		ModelChecker<SuseracInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;		
		checker = new SuseracCheckHasData(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SuseracInfo>> buildActionsOnPassedHook(DeciTreeOption<SuseracInfo> option) {
		List<ActionStd<SuseracInfo>> actions = new ArrayList<>();

		ActionStd<SuseracInfo> success = new StdSuseracSuccess(option);
		
		actions.add(success);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SuseracInfo>> buildActionsOnFailedHook(DeciTreeOption<SuseracInfo> option) {
		List<ActionStd<SuseracInfo>> actions = new ArrayList<>();

		ActionStd<SuseracInfo> zerofy = new StdSuseracEnforceZerofy(option);
		
		actions.add(zerofy);
		return actions;
	}
}
