package br.com.gda.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.materialStore.model.action.LazyMatoreRootDelete;
import br.com.gda.business.materialStore.model.action.StdMatoreMergeToDelete;
import br.com.gda.business.materialStore.model.checker.MatoreCheckDeleteByMat;
import br.com.gda.model.action.ActionLazy;
import br.com.gda.model.action.ActionStd;
import br.com.gda.model.checker.ModelChecker;
import br.com.gda.model.checker.ModelCheckerQueue;
import br.com.gda.model.decisionTree.DeciTreeOption;
import br.com.gda.model.decisionTree.DeciTreeWriteTemplate;

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
