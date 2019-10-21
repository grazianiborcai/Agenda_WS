package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.business.masterData.model.action.StdAuthGroupSelect;
import br.com.mind5.business.masterData.model.checker.AuthGroupCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootAuthGroupSelect extends DeciTreeReadTemplate<AuthGroupInfo> {
	
	public RootAuthGroupSelect(DeciTreeOption<AuthGroupInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<AuthGroupInfo> buildDecisionCheckerHook(DeciTreeOption<AuthGroupInfo> option) {
		List<ModelChecker<AuthGroupInfo>> queue = new ArrayList<>();		
		ModelChecker<AuthGroupInfo> checker;
		
		checker = new AuthGroupCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<AuthGroupInfo>> buildActionsOnPassedHook(DeciTreeOption<AuthGroupInfo> option) {
		List<ActionStd<AuthGroupInfo>> actions = new ArrayList<>();
		
		ActionStd<AuthGroupInfo> select = new StdAuthGroupSelect(option);
		
		actions.add(select);		
		return actions;
	}
}
