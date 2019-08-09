package br.com.gda.business.masterData.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.info.EntityCategInfo;
import br.com.gda.business.masterData.model.action.StdEntityCategSelect;
import br.com.gda.business.masterData.model.checker.EntityCategCheckRead;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeReadTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

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
