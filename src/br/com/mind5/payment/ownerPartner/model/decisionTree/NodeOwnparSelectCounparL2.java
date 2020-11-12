package br.com.mind5.payment.ownerPartner.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateReadV2;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;
import br.com.mind5.payment.ownerPartner.model.action.StdOwnparMergeCounpar;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckCounpar;
import br.com.mind5.payment.ownerPartner.model.checker.OwnparCheckHasCountry;

public final class NodeOwnparSelectCounparL2 extends DeciTreeTemplateReadV2<OwnparInfo> {
	
	public NodeOwnparSelectCounparL2(DeciTreeOption<OwnparInfo> option) {
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
		checker = new OwnparCheckHasCountry(checkerOption);
		queue.add(checker);	
		
		checkerOption = new ModelCheckerOption();
		checkerOption.conn = option.conn;
		checkerOption.schemaName = option.schemaName;
		checkerOption.expectedResult = ModelCheckerOption.EXIST_ON_DB;		
		checker = new OwnparCheckCounpar(checkerOption);
		queue.add(checker);	
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<OwnparInfo>> buildActionsOnPassedHook(DeciTreeOption<OwnparInfo> option) {
		List<ActionStdV1<OwnparInfo>> actions = new ArrayList<>();
		
		ActionStdV1<OwnparInfo> mergeCountry = new StdOwnparMergeCounpar(option);
		
		actions.add(mergeCountry);
		return actions;
	}
}
