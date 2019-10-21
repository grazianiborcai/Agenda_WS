package br.com.mind5.business.orderItemSnapshot.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.orderItemSnapshot.model.action.LazyOrdemrapMergeMatsnap;
import br.com.mind5.business.orderItemSnapshot.model.action.StdOrdemrapMergeToSelect;
import br.com.mind5.business.orderItemSnapshot.model.checker.OrdemrapCheckRead;
import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;

public final class RootOrdemrapSelect extends DeciTreeWriteTemplate<OrdemrapInfo> {
	
	public RootOrdemrapSelect(DeciTreeOption<OrdemrapInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OrdemrapInfo> buildDecisionCheckerHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ModelChecker<OrdemrapInfo>> queue = new ArrayList<>();		
		ModelChecker<OrdemrapInfo> checker;
		
		checker = new OrdemrapCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OrdemrapInfo>> buildActionsOnPassedHook(DeciTreeOption<OrdemrapInfo> option) {
		List<ActionStd<OrdemrapInfo>> actions = new ArrayList<>();
		
		ActionStd<OrdemrapInfo> select = new StdOrdemrapMergeToSelect(option);
		ActionLazy<OrdemrapInfo> mergeMatsnap = new LazyOrdemrapMergeMatsnap(option.conn, option.schemaName);
		
		select.addPostAction(mergeMatsnap);
		
		actions.add(select);
		return actions;
	}
}
