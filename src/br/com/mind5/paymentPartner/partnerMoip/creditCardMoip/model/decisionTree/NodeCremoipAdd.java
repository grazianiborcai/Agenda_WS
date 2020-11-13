package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStdV1;
import br.com.mind5.model.checker.ModelCheckerHelperQueueV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.model.checker.common.ModelCheckerDummy;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeTemplateWriteV2;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipAdd;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceHolder;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipEnforceDocument;

public final class NodeCremoipAdd extends DeciTreeTemplateWriteV2<CremoipInfo> {
	
	public NodeCremoipAdd(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelCheckerV1<CremoipInfo> buildCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelCheckerV1<CremoipInfo>> queue = new ArrayList<>();		
		ModelCheckerV1<CremoipInfo> checker;	

		checker = new ModelCheckerDummy<>();
		queue.add(checker);
		
		return new ModelCheckerHelperQueueV2<>(queue);
	}
	
	
	
	@Override protected List<ActionStdV1<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStdV1<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStdV1<CremoipInfo> enforceDocument = new StdCremoipEnforceDocument(option);		
		ActionLazy<CremoipInfo> enforceHolder = new LazyCremoipEnforceHolder(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceCard = new LazyCremoipEnforceCard(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> enforceFunding = new LazyCremoipEnforceFunding(option.conn, option.schemaName);
		ActionLazy<CremoipInfo> addCard = new LazyCremoipAdd(option.conn, option.schemaName);

		enforceDocument.addPostAction(enforceHolder);
		enforceHolder.addPostAction(enforceCard);
		enforceCard.addPostAction(enforceFunding);
		enforceFunding.addPostAction(addCard);
		
		actions.add(enforceDocument);
		return actions;
	}
}
