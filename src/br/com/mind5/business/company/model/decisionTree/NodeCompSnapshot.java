package br.com.mind5.business.company.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.business.company.model.action.LazyCompUpdate;
import br.com.mind5.business.company.model.action.StdCompInsertCompnap;
import br.com.mind5.business.company.model.checker.CompCheckDummy;
import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class NodeCompSnapshot extends DeciTreeWriteTemplate<CompInfo> {
	
	public NodeCompSnapshot(DeciTreeOption<CompInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CompInfo> buildCheckerHook(DeciTreeOption<CompInfo> option) {
		List<ModelChecker<CompInfo>> queue = new ArrayList<>();		
		ModelChecker<CompInfo> checker;	
		
		checker = new CompCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CompInfo>> buildActionsOnPassedHook(DeciTreeOption<CompInfo> option) {
		List<ActionStdV1<CompInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CompInfo> insertSnapshot = new StdCompInsertCompnap(option);		
		ActionLazyV1<CompInfo> update = new LazyCompUpdate(option.conn, option.schemaName);	
		
		insertSnapshot.addPostAction(update);
		
		actions.add(insertSnapshot);	
		return actions;
	}
}
