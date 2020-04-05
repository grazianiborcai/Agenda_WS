package br.com.mind5.business.materialMovement.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialMovement.model.action.LazyMatmovUpdate;
import br.com.mind5.business.materialMovement.model.action.StdMatmovUpsertMatock;
import br.com.mind5.business.materialMovement.model.checker.MatmovCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatmovMatock extends DeciTreeWriteTemplate<MatmovInfo> {
	
	public NodeMatmovMatock(DeciTreeOption<MatmovInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatmovInfo> buildCheckerHook(DeciTreeOption<MatmovInfo> option) {
		List<ModelChecker<MatmovInfo>> queue = new ArrayList<>();		
		ModelChecker<MatmovInfo> checker;
		
		checker = new MatmovCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatmovInfo>> buildActionsOnPassedHook(DeciTreeOption<MatmovInfo> option) {
		List<ActionStdV1<MatmovInfo>> actions = new ArrayList<>();

		ActionStdV1<MatmovInfo> upsertStock = new StdMatmovUpsertMatock(option);
		ActionLazyV1<MatmovInfo> update = new LazyMatmovUpdate(option.conn, option.schemaName);
		
		upsertStock.addPostAction(update);
		
		actions.add(upsertStock);	
		return actions;
	}
}
