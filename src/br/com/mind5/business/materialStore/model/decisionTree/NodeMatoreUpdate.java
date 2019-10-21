package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.StdMatoreUpdate;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckHasMatCateg;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckPriceProduct;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckPriceService;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatoreUpdate extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public NodeMatoreUpdate(DeciTreeOption<MatoreInfo> option) {
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
		
		ActionStd<MatoreInfo> update = new StdMatoreUpdate(option);
		ActionStd<MatoreInfo> select = new RootMatoreSelect(option).toAction();

		actions.add(update);
		actions.add(select);
				
		return actions;
	}
}
