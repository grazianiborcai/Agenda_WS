package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckExist;

public final class NodeOwnparSelect extends DeciTreeTemplateReadV2<OwnparInfo> {
	
	public NodeOwnparSelect(DeciTreeOption<OwnparInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<OwnparInfo> buildCheckerHook(DeciTreeOption<OwnparInfo> option) {
		List<ModelCheckerV1<OwnparInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<OwnparInfo> checker;
		ModelCheckerOption checkerOption;
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnparCheckExist(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV2<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStdV2<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OwnparInfo> nodeSelectOwnpar = new NodeOwnparSelectOwnpar(option).toAction();
		
		actions.add(nodeSelectOwnpar);
		return actions;
	}
	
	
	
	@Override protected List<ActionStdV2<OwnparInfo>> buildActionsOnFailedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStdV2<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStdV2<OwnparInfo> nodeSelectCounpar = new NodeOwnparSelectCounparL1(option).toAction();
		
		actions.add(nodeSelectCounpar);
		return actions;
	}
}
