package br.com.mind5.file.fileImageList.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.file.fileImageList.model.action.LazyFimistRootSelect;
import br.com.mind5.file.fileImageList.model.action.StdFimistMergeFimarch;
import br.com.mind5.file.fileImageList.model.checker.FimistCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;

public final class RootFimistSearch extends DeciTreeReadTemplate<FimistInfo> {
	
	public RootFimistSearch(DeciTreeOption<FimistInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<FimistInfo> buildDecisionCheckerHook(DeciTreeOption<FimistInfo> option) {
		List<ModelChecker<FimistInfo>> queue = new ArrayList<>();		
		ModelChecker<FimistInfo> checker;	

		checker = new FimistCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<FimistInfo>> buildActionsOnPassedHook(DeciTreeOption<FimistInfo> option) {
		List<ActionStdV1<FimistInfo>> actions = new ArrayList<>();
		
		ActionStdV1<FimistInfo> mergeFimarch = new StdFimistMergeFimarch(option);
		ActionLazyV1<FimistInfo> select = new LazyFimistRootSelect(option.conn, option.schemaName);
		
		mergeFimarch.addPostAction(select);
		
		actions.add(mergeFimarch);
		return actions;
	}
}
