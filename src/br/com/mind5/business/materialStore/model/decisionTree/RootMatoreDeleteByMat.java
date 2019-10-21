package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootDelete;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeToDelete;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDeleteByMat;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootMatoreDeleteByMat extends DeciTreeWriteTemplate<MatoreInfo> {
	
	public RootMatoreDeleteByMat(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
		
		checker = new MatoreCheckDeleteByMat();
		queue.add(checker);
		
		return new ModelCheckerQueue<MatoreInfo>(queue);
	}
	
	
	
	@Override protected List<ActionStd<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStd<MatoreInfo>> actions = new ArrayList<>();		
		
		ActionStd<MatoreInfo> mergeToDelete = new StdMatoreMergeToDelete(option);
		ActionLazy<MatoreInfo> rootDelete = new LazyMatoreRootDelete(option.conn, option.schemaName);
		
		mergeToDelete.addPostAction(rootDelete);
		
		actions.add(mergeToDelete);
		return actions;
	}
}
