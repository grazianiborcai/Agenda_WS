package br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.decisionTree;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.model.action.ActionLazy;
import br.com.mind5.model.action.ActionStd;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.model.checker.ModelCheckerQueue;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.model.decisionTree.DeciTreeWriteTemplate;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.info.CremoipInfo;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipAdd;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceCard;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceFunding;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.LazyCremoipEnforceHolder;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.action.StdCremoipEnforceDocument;
import br.com.mind5.paymentPartner.partnerMoip.creditCardMoip.model.checker.CremoipCheckDummy;

public final class NodeCremoipAdd extends DeciTreeWriteTemplate<CremoipInfo> {
	
	public NodeCremoipAdd(DeciTreeOption<CremoipInfo> option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<CremoipInfo> buildDecisionCheckerHook(DeciTreeOption<CremoipInfo> option) {
		List<ModelChecker<CremoipInfo>> queue = new ArrayList<>();		
		ModelChecker<CremoipInfo> checker;	

		checker = new CremoipCheckDummy();
		queue.add(checker);
		
		return new ModelCheckerQueue<>(queue);
	}
	
	
	
	@Override protected List<ActionStd<CremoipInfo>> buildActionsOnPassedHook(DeciTreeOption<CremoipInfo> option) {
		List<ActionStd<CremoipInfo>> actions = new ArrayList<>();
		
		ActionStd<CremoipInfo> enforceDocument = new StdCremoipEnforceDocument(option);		
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
