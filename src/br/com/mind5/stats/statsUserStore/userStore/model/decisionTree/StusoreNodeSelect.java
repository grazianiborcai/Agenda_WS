package br.com.mind5.stats.statsUserStore.userStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.action.commom.ActionStdCommom;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWrite;
import br.com.mind5.stats.statsUserStore.userStore.info.StusoreInfo;
import br.com.mind5.stats.statsUserStore.userStore.model.action.StusoreVisiMergeStusoragg;
import br.com.mind5.stats.statsUserStore.userStore.model.action.StusoreVisiMergeStusoreve;
import br.com.mind5.stats.statsUserStore.userStore.model.checker.StusoreCheckStusorage;


public final class StusoreNodeSelect extends DeciTreeTemplateWrite<StusoreInfo> {
	
	public StusoreNodeSelect(DeciTreeOption<StusoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<StusoreInfo> buildCheckerHook(DeciTreeOption<StusoreInfo> option) {
		List<ModelChecker<StusoreInfo>> queue = new ArrayList<>();		
		ModelChecker<StusoreInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new StusoreCheckStusorage(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<StusoreInfo>> buildActionsOnPassedHook(DeciTreeOption<StusoreInfo> option) {
		List<ActionStd<StusoreInfo>> actions = new ArrayList<>();

		ActionStd<StusoreInfo> selectLive = new ActionStdCommom<StusoreInfo>(option, StusoreVisiMergeStusoreve.class);
		
		actions.add(selectLive);
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<StusoreInfo>> buildActionsOnFailedHook(DeciTreeOption<StusoreInfo> option) {
		List<ActionStd<StusoreInfo>> actions = new ArrayList<>();

		ActionStd<StusoreInfo> selectAggregated = new ActionStdCommom<StusoreInfo>(option, StusoreVisiMergeStusoragg.class);
		
		actions.add(selectAggregated);
		return actions;
	}
}
