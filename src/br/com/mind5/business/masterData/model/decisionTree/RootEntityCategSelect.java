package br.com.mind5.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.EntityCategInfo;
import br.com.mind5.business.masterData.model.action.StdEntityCategSelect;
import br.com.mind5.business.masterData.model.checker.EntityCategCheckRead;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootEntityCategSelect extends DeciTreeReadTemplate<EntityCategInfo> {
	
	public RootEntityCategSelect(DeciTreeOption<EntityCategInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<EntityCategInfo> buildDecisionCheckerHook(DeciTreeOption<EntityCategInfo> option) {
		List<ModelChecker<EntityCategInfo>> queue = new ArrayList<>();		
		ModelChecker<EntityCategInfo> checker;
		
		checker = new EntityCategCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}

		
	
	@Override protected List<ActionStd<EntityCategInfo>> buildActionsOnPassedHook(DeciTreeOption<EntityCategInfo> option) {
		List<ActionStd<EntityCategInfo>> actions = new ArrayList<>();
		
		actions.add(new StdEntityCategSelect(option));
		return actions;
	}
}
