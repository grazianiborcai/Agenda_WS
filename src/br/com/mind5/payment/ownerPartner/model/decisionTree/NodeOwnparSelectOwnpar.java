package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazyV1;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
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
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStdV1<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnparInfo> mergeToSelect = new StdOwnparMergeToSelect(option);
		ActionLazyV1<OwnparInfo> mergeOwner = new LazyOwnparMergeOwner(option.conn, option.schemaName);
		
		mergeToSelect.addPostAction(mergeOwner);
		
		actions.add(mergeToSelect);
		return actions;
	}
}
