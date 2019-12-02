package br.com.mind5.business.material.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.action.LazyMatEnforceLChanged;
import br.com.mind5.business.material.model.action.LazyMatMergeUsername;
import br.com.mind5.business.material.model.action.LazyMatNodeServiceL1;
import br.com.mind5.business.material.model.action.LazyMatUpdate;
import br.com.mind5.business.material.model.action.StdMatMergeToUpdate;
import br.com.mind5.business.material.model.checker.MatCheckDummy;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeMatUpdate extends DeciTreeWriteTemplate<MatInfo> {
	
	public NodeMatUpdate(DeciTreeOption<MatInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> buildDecisionCheckerHook(DeciTreeOption<MatInfo> option) {
		List<ModelChecker<MatInfo>> queue = new ArrayList<>();		
		ModelChecker<MatInfo> checker;

		checker = new MatCheckDummy();
		queue.add(checker);

		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatInfo>> buildActionsOnPassedHook(DeciTreeOption<MatInfo> option) {
		List<ActionStd<MatInfo>> actions = new ArrayList<>();

		ActionStd<MatInfo> mergeToUpdate = new StdMatMergeToUpdate(option);	
		ActionLazy<MatInfo> nodeService = new LazyMatNodeServiceL1(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceLChanged = new LazyMatEnforceLChanged(option.conn, option.schemaName);	
		ActionLazy<MatInfo> enforceLChangedBy = new LazyMatMergeUsername(option.conn, option.schemaName);
		ActionLazy<MatInfo> updateMat = new LazyMatUpdate(option.conn, option.schemaName);	
		
		mergeToUpdate.addPostAction(nodeService);
		nodeService.addPostAction(enforceLChanged);
		enforceLChanged.addPostAction(enforceLChangedBy);
		enforceLChangedBy.addPostAction(updateMat);
		
		actions.add(mergeToUpdate);
		return actions;
	}
}
