package br.com.gda.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.business.materialStock.model.action.StdMatockInsert;
import br.com.gda.business.materialStock.model.checker.MatockCheckInsert;
import br.com.gda.business.materialStock.model.checker.MatockCheckLimit;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeMatockInsert extends DeciTreeWriteTemplate<MatockInfo> {
	
	public NodeMatockInsert(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		
		checker = new MatockCheckLimit();
		queue.add(checker);
		
		checker = new MatockCheckInsert();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();

		ActionStd<MatockInfo> insert = new StdMatockInsert(option);
		ActionStd<MatockInfo> select = new RootMatockSelect(option).toAction();	
		
		actions.add(insert);	
		actions.add(select);
		return actions;
	}
}
