package br.com.mind5.business.materialStock.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.business.materialStock.model.action.StdMatockUpdate;
import br.com.mind5.business.materialStock.model.checker.MatockCheckBalance;
import br.com.mind5.business.materialStock.model.checker.MatockCheckLimit;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatockUpdate extends DeciTreeWriteTemplate<MatockInfo> {
	
	public NodeMatockUpdate(DeciTreeOption<MatockInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatockInfo> buildDecisionCheckerHook(DeciTreeOption<MatockInfo> option) {
		List<ModelChecker<MatockInfo>> queue = new ArrayList<>();		
		ModelChecker<MatockInfo> checker;
		
		checker = new MatockCheckBalance();
		queue.add(checker);
		
		checker = new MatockCheckLimit();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatockInfo>> buildActionsOnPassedHook(DeciTreeOption<MatockInfo> option) {
		List<ActionStd<MatockInfo>> actions = new ArrayList<>();
		
		ActionStd<MatockInfo> update = new StdMatockUpdate(option);	
		ActionStd<MatockInfo> select = new RootMatockSelect(option).toAction();	

		actions.add(update);
		actions.add(select);
		return actions;
	}
}
