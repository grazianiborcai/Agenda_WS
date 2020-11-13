package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateRead;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.LazyOwnparMergeOwner;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparMergeToSelect;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class NodeOwnparSelectOwnpar extends DeciTreeTemplateRead<OwnparInfo> {
	
	public NodeOwnparSelectOwnpar(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<OwnparInfo> buildCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelChecker<OwnparInfo>> queue = new ArrayList<>();		
		ModelChecker<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueue<>(queue);
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
