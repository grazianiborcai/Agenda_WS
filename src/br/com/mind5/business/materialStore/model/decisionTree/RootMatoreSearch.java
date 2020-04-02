package br.com.mind5.business.materialStore.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.action.LazyMatoreRootSelect;
import br.com.mind5.business.materialStore.model.action.StdMatoreMergeMatorarch;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootMatoreSearch extends DeciTreeReadTemplate<MatoreInfo> {
	
	public RootMatoreSearch(DeciTreeOption<MatoreInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatoreInfo> buildDecisionCheckerHook(DeciTreeOption<MatoreInfo> option) {
		List<ModelChecker<MatoreInfo>> queue = new ArrayList<>();		
		ModelChecker<MatoreInfo> checker;
			
		checker = new MatoreCheckDummy();
		queue.add(checker);	
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<MatoreInfo>> buildActionsOnPassedHook(DeciTreeOption<MatoreInfo> option) {
		List<ActionStdV1<MatoreInfo>> actions = new ArrayList<>();
		
		ActionStdV1<MatoreInfo> mergeMatorarch = new StdMatoreMergeMatorarch(option);
		ActionLazyV1<MatoreInfo> select = new LazyMatoreRootSelect(option.conn, option.schemaName);	
		
		mergeMatorarch.addPostAction(select);
		
		actions.add(mergeMatorarch);		
		return actions;
	}
}
