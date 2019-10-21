package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeReadTemplate;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.LazyOwnparMergeOwner;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparMergeToSelect;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class NodeOwnparSelectOwnpar extends DeciTreeReadTemplate<OwnparInfo> {
	
	public NodeOwnparSelectOwnpar(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnparInfo> buildDecisionCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		
		checker = new OwnparCheckRead();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStd<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStd<OwnparInfo> mergeToSelect = new StdOwnparMergeToSelect(option);
		ActionLazy<OwnparInfo> mergeOwner = new LazyOwnparMergeOwner(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeOwner);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
