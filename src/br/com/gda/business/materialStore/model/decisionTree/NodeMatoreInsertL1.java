package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.checker.MatoreCheckHasMatCateg;
import br.com.gda.business.materialStore.model.checker.MatoreCheckPriceProduct;
import br.com.gda.business.materialStore.model.checker.MatoreCheckPriceService;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatoreInsertL1 extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public NodeMatoreInsertL1(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		
		checker = new MatoreCheckHasMatCateg();
		queue.add(checker);	
		
		checker = new MatoreCheckPriceService();
		queue.add(checker);
		
		checker = new MatoreCheckPriceProduct();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStd<MatoreInfo> nodeInsertL2 = new NodeMatoreInsertL2(option).toAction();		
		actions.add(nodeInsertL2);
		
		return actions;
	}
}
