package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatUpdate;
import br.com.mind5.business.material.model.action.StdMatInsertMatsnap;
import br.com.mind5.business.material.model.checker.MatCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatSnapshot extends DeciTreeWriteTemplate<MatInfo> {
	
	public NodeMatSnapshot(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;

		checker = new MatCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStdV1<MatInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatInfo> insertMatsnap = new StdMatInsertMatsnap(option);
		ActionLazyV1<MatInfo> update = new LazyMatUpdate(option.conn, option.schemaName);
		
		insertMatsnap.addPostAction(update);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
