package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.LazyOwnparNodeSelectCounparL2;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparMergeOwner;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckRead;

public final class NodeOwnparSelectCounparL1 extends DeciTreeTemplateReadV2<OwnparInfo> {
	
	public NodeOwnparSelectCounparL1(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnparInfo> buildCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelCheckerV1<OwnparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.SUCCESS;	
		checker = new OwnparCheckRead(checkerOption);
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStdV1<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnparInfo> mergeOwner = new StdOwnparMergeOwner(option);
		ActionLazy<OwnparInfo> nodeSelectL1 = new LazyOwnparNodeSelectCounparL2(option.conn, option.schemaName);
		
		mergeOwner.addPostAction(nodeSelectL1);
		
		actions.add(mergeOwner);
		return actions;
	}
}
