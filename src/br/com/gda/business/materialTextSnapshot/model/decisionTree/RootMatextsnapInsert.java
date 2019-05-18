package br.com.gda.business.materialTextSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.business.materialTextSnapshot.model.action.StdMatextsnapInsert;
import br.com.gda.business.materialTextSnapshot.model.checker.MatextsnapCheckWrite;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatextsnapInsert extends DeciTreeWriteTemplate<MatextsnapInfo> {
	
	public RootMatextsnapInsert(DeciTreeOption<MatextsnapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatextsnapInfo> buildDecisionCheckerHook(DeciTreeOption<MatextsnapInfo> option) {		
		List<ModelChecker<MatextsnapInfo>> queue = new ArrayList<>();		
		ModelChecker<MatextsnapInfo> checker;
		
		checker = new MatextsnapCheckWrite();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatextsnapInfo>> buildActionsOnPassedHook(DeciTreeOption<MatextsnapInfo> option) {
		List<ActionStd<MatextsnapInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatextsnapInfo> insert = new StdMatextsnapInsert(option);	
		actions.add(insert);
		return actions;
	}
}
