package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatInsertMatextsnap;
import br.com.mind5.business.material.model.action.LazyMatUpdate;
import br.com.mind5.business.material.model.action.StdMatInsertMatsnap;
import br.com.mind5.business.material.model.checker.MatCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
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
			
		checker = new MatCheckRead();
		queue.add(checker);	

		return new ModelCheckerQueue<MatInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();
		
		ActionStd<MatInfo> insertMatsnap = new StdMatInsertMatsnap(option);
		ActionLazy<MatInfo> insertMatextsnap = new LazyMatInsertMatextsnap(option.conn, option.schemaName);
		ActionLazy<MatInfo> update = new LazyMatUpdate(option.conn, option.schemaName);
		
		insertMatsnap.addPostAction(insertMatextsnap);
		insertMatextsnap.addPostAction(update);
		
		actions.add(insertMatsnap);
		return actions;
	}
}
