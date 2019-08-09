package br.com.gda.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.model.action.ActionStd;
import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.business.materialMovement.model.action.LazyMatmovRootSelect;
import br.com.gda.business.materialMovement.model.action.LazyMatmovUpsertMatock;
import br.com.gda.business.materialMovement.model.action.StdMatmovInsert;
import br.com.gda.business.materialMovement.model.checker.MatmovCheckProduct;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;
import br.com.gda.model.decisionTree.DeciTreeOption;

public final class NodeMatmovInsert extends DeciTreeWriteTemplate<MatmovInfo> {
	
	public NodeMatmovInsert(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildDecisionCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;	
		
		checker = new MatmovCheckProduct();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStd<MatmovInfo>> actions = new ArrayList<>();

		ActionStd<MatmovInfo> insert = new StdMatmovInsert(option);
		ActionLazy<MatmovInfo> upsertStock = new LazyMatmovUpsertMatock(option.conn, option.schemaName);
		ActionLazy<MatmovInfo> select = new LazyMatmovRootSelect(option.conn, option.schemaName);	
		
		insert.addPostAction(upsertStock);
		insert.addPostAction(select);
		
		actions.add(insert);	
		return actions;
	}
}
