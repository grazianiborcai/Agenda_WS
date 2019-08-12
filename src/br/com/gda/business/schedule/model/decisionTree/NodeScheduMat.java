package br.com.gda.business.schedule.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.business.schedule.model.action.StdScheduSuccess;
import br.com.gda.business.schedule.model.checker.SheduCheckIsService;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeScheduMat extends DeciTreeWriteTemplate<ScheduInfo> {
	
	public NodeScheduMat(DeciTreeOption<ScheduInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<ScheduInfo> buildDecisionCheckerHook(DeciTreeOption<ScheduInfo> option) {
		List<ModelChecker<ScheduInfo>> queue = new ArrayList<>();		
		ModelChecker<ScheduInfo> checker;	
		
		checker = new SheduCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<ScheduInfo>> buildActionsOnPassedHook(DeciTreeOption<ScheduInfo> option) {
		List<ActionStd<ScheduInfo>> actions = new ArrayList<>();
		
		ActionStd<ScheduInfo> success = new StdScheduSuccess(option);
		
		actions.add(success);
		return actions;
	}
}
