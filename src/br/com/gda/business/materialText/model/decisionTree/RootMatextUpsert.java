package br.com.gda.business.materialText.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.business.materialText.model.checker.MatextCheckWrite;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextUpsert extends DeciTreeWriteTemplate<MatextInfo> {
	
	public RootMatextUpsert(DeciTreeOption<MatextInfo> option) {
		super(option);
	}	
	
	
	
	@Override protected ModelChecker<MatextInfo> buildDecisionCheckerHook(DeciTreeOption<MatextInfo> option) {
		List<ModelChecker<MatextInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextInfo> checker;	
		
		checker = new MatextCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextInfo> option) {
		List<ActionStd<MatextInfo>> actions = new ArrayList<>();
		
		ActionStd<MatextInfo> nodeUpdate = new NodeMatextUpsert(option).toAction();
		
		actions.add(nodeUpdate);
		return actions;
	}
}
