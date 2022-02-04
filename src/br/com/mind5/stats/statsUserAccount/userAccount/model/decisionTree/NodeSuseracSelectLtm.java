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
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.StdSuseracMergeSuseracive;
import br.com.mind5.stats.statsUserAccount.userAccount.model.action.StdSuseracSuccess;
import br.com.mind5.stats.statsUserAccount.userAccount.model.checker.SuseracCheckSuseracive;


public final class NodeSuseracSelectLtm extends DeciTreeTemplateWrite<SuseracInfo> {
	
	public NodeSuseracSelectLtm(DeciTreeOption<SuseracInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<SuseracInfo> buildCheckerHook(DeciTreeOption<SuseracInfo> option) {
		List<ModelChecker<SuseracInfo>> queue = new ArrayList<>();		
		ModelChecker<SuseracInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new SuseracCheckSuseracive(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<SuseracInfo>> buildActionsOnPassedHook(DeciTreeOption<SuseracInfo> option) {
		List<ActionStd<SuseracInfo>> actions = new ArrayList<>();

		ActionStd<SuseracInfo> mergeStoracive = new StdSuseracMergeSuseracive(option);
		
		actions.add(mergeStoracive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<SuseracInfo>> buildActionsOnFailedHook(DeciTreeOption<SuseracInfo> option) {
		List<ActionStd<SuseracInfo>> actions = new ArrayList<>();

		ActionStd<SuseracInfo> success = new StdSuseracSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
