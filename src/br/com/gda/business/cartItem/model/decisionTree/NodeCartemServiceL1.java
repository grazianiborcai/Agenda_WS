package br.com.gda.business.cartItem.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.cartItem.info.CartemInfo;
import br.com.gda.business.cartItem.model.action.StdCartemSuccess;
import br.com.gda.business.cartItem.model.checker.CartemCheckIsService;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCartemServiceL1 extends DeciTreeWriteTemplate<CartemInfo> {
	
	public NodeCartemServiceL1(DeciTreeOption<CartemInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CartemInfo> buildDecisionCheckerHook(DeciTreeOption<CartemInfo> option) {
		List<ModelChecker<CartemInfo>> queue = new ArrayList<>();		
		ModelChecker<CartemInfo> checker;	
		
		checker = new CartemCheckIsService();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnPassedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> nodeL2 = new NodeCartemServiceL2(option).toAction();
		actions.add(nodeL2);
		
		return actions;
	}
	
	
	
	@Override protected List<ActionStd<CartemInfo>> buildActionsOnFailedHook(DeciTreeOption<CartemInfo> option) {
		List<ActionStd<CartemInfo>> actions = new ArrayList<>();
		
		ActionStd<CartemInfo> success = new StdCartemSuccess(option);			
		actions.add(success);
		
		return actions;
	}
}
